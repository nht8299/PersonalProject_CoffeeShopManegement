package com.axonactive.coffeeshopmanagement.controller;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.service.CategoryService;
import com.axonactive.coffeeshopmanagement.service.dto.CategoryDto;
import com.axonactive.coffeeshopmanagement.service.mapper.CategoryMapper;
import com.axonactive.coffeeshopmanagement.controller.request.CategoryRequest;
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

    public static final String PATH = "/api/categories";

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAll(){
        return ResponseEntity.ok(categoryMapper.toDtos(categoryService.getAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findCategoryById(@PathVariable(value = "id")Integer id)throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.findCategory(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found "+ id))));
    }

    @PostMapping
    public ResponseEntity<CategoryDto> add(@RequestBody CategoryRequest category){
        Category newCategory = categoryService.saveCategory(category);
        return ResponseEntity
                .created(URI.create(CategoryResource.PATH + "/" + newCategory.getId()))
                .body(categoryMapper.toDto(newCategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id")Integer id){
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> update(@PathVariable(value = "id")Integer id,@RequestBody CategoryRequest requestCategory) throws ResourceNotFoundException {
        return ResponseEntity.ok(categoryMapper.toDto(categoryService.updateCategory(id,requestCategory)));
    }
}
