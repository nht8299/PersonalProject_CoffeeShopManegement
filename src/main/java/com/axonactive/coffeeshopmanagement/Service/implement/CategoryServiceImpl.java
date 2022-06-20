package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CategoryService;
import com.axonactive.coffeeshopmanagement.api.request.CategoryRequest;
import com.axonactive.coffeeshopmanagement.entities.Category;
import com.axonactive.coffeeshopmanagement.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    public final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category saveCategory(CategoryRequest requestCategory) {
        Category newCategory =new Category();
        newCategory.setName(requestCategory.getName());
        newCategory.setDescription(requestCategory.getDescription());
        return categoryRepository.save(newCategory);
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(Integer id, CategoryRequest categoryDetail) throws ResourceNotFoundException {
        Category updateCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category Not Found: " + id));
        updateCategory.setName(categoryDetail.getName());
        updateCategory.setDescription(categoryDetail.getDescription());
        return categoryRepository.save(updateCategory);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameContaining(name);
    }
}
