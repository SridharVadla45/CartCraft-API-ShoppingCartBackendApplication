package com.sridhar.dev.shopping_cart.service.impl;

import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.exception.ResourceNotFoundException;
import com.sridhar.dev.shopping_cart.repository.CategoryRepository;
import com.sridhar.dev.shopping_cart.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {

        categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
      categoryRepository.findById(id).ifPresentOrElse(categoryRepository::delete, () -> {throw new ResourceNotFoundException("Category", "categoryId", id);});
    }

    @Override
    public void updateCategory(Long id, Category category) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", id));
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());
        categoryRepository.save(existingCategory);
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", id)
        );
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }
}
