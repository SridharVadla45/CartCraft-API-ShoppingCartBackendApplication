package com.sridhar.dev.shopping_cart.service.impl;

import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.service.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Override
    public Category getCategoryById(Long id) {
        return null;
    }

    @Override
    public Category getCategoryByName(String name) {
        return null;
    }

    @Override
    public List<Category> getAllCategories() {
        return List.of();
    }

    @Override
    public Category addCategory(Category category) {
        return null;
    }

    @Override
    public Category updateCategory(Category category, Long id) {
        return null;
    }

    @Override
    public void deleteCategoryById(Long id) {

    }
}
