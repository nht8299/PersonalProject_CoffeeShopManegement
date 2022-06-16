package com.axonactive.coffeeshopmanagement.api;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CategoryService;
import com.axonactive.coffeeshopmanagement.Service.dto.CategoryDto;
import com.axonactive.coffeeshopmanagement.Service.mapper.CategoryMapper;
import com.axonactive.coffeeshopmanagement.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@CrossOrigin(value = "3600")
@RestController
@RequestMapping(CategoryResource.PATH)
public class CategoryResource {

    public static final String PATH = "/api/category";

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(){
        return ResponseEntity.ok(categoryMapper.toDtos(categoryService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable(value = "id")Integer id)throws NotFoundException{
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.findCategory(id)
                .orElseThrow(() -> new NotFoundException("Category not found "+ id))));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> add(@RequestBody Category category){
        Category newCategory =new Category();
        newCategory.setName(category.getName());
        newCategory.setDescription(category.getDescription());
        Category createCategory = categoryService.saveCategory(newCategory);
        return ResponseEntity
                .created(URI.create(CategoryResource.PATH + "/" + createCategory.getId()))
                .body(categoryMapper.toDto(createCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable(value = "id")Integer id,@RequestBody Category requestCategory) throws NotFoundException {
        Category updateCategory = new Category();
        updateCategory.setName(requestCategory.getName());
        updateCategory.setDescription(requestCategory.getDescription());
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.updateCategory(id,updateCategory)));
    }
}
