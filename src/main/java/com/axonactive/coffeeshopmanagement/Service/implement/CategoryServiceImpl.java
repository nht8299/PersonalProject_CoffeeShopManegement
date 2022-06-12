package com.axonactive.coffeeshopmanagement.Service.implement;

import com.axonactive.coffeeshopmanagement.Exception.NotFoundException;
import com.axonactive.coffeeshopmanagement.Service.CategoryService;
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
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Optional<Category> findCategory(String id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category updateCategory(String id, Category categoryDetail) throws NotFoundException {
        Category updateCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category Not Found: " + id));
        updateCategory.setName(categoryDetail.getName());
        updateCategory.setDescription(categoryDetail.getDescription());
        return categoryRepository.save(updateCategory);
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByNameContaining(name);
    }
}
