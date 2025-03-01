package com.sridhar.dev.shopping_cart.service;

import com.sridhar.dev.shopping_cart.entity.Category;

import java.util.List;

public interface ICategoryService {

    void createCategory(Category category);

    void deleteCategory(Long id);

    void updateCategory(Long id, Category category);

    Category getCategory(Long id);

    List<Category> getCategories();

}
