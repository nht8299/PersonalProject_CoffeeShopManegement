package com.axonactive.coffeeshopmanagement.service;

import com.axonactive.coffeeshopmanagement.exception.ResourceNotFoundException;
import com.axonactive.coffeeshopmanagement.api.request.CategoryRequest;
import com.axonactive.coffeeshopmanagement.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Category saveCategory(CategoryRequest category);

    void deleteCategory(Integer id);

    Optional<Category> findCategory(Integer id);

    Category updateCategory(Integer id,CategoryRequest categoryDetail) throws ResourceNotFoundException;

    Category findByName(String name);
}
