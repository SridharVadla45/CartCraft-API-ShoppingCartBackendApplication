package com.sridhar.dev.shopping_cart.mapper;

import com.sridhar.dev.shopping_cart.dto.CategoryDto;
import com.sridhar.dev.shopping_cart.entity.Category;

public final class CategoryMapper {
    private CategoryMapper(){}

    public static CategoryDto toDto(Category category) {
        return CategoryDto.builder().name(category.getName()).description(category.getDescription()).
                id(category.getId()).build();
    }


}
