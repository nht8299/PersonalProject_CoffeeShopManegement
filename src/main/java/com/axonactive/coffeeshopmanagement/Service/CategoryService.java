package com.axonactive.coffeeshopmanagement.Service;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.entities.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAll();

    Category saveCategory(Category category);

    void deleteCategory(Integer id);

    Optional<Category> findCategory(Integer id);

    Category updateCategory(Integer id,Category categoryDetail) throws NotFoundException;

    Category findByName(String name);
}
