package com.sridhar.dev.shopping_cart.service;

import com.sridhar.dev.shopping_cart.entity.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);

    Category getCategoryByName(String name);

    List<Category> getAllCategories();

    Category addCategory(Category category);

    Category updateCategory(Category category, Long id);

    void deleteCategoryById(Long id);

}