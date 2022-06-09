package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Category saveCategory(Category category);

    void deleteCategory(String id);

    Optional<Category> findCategory(String id);
}
