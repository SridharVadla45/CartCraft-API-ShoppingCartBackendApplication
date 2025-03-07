package com.sridhar.dev.shopping_cart.mapper;

import com.sridhar.dev.shopping_cart.dto.ProductDto;
import com.sridhar.dev.shopping_cart.entity.Product;

public final class ProductMapper {
    private ProductMapper(){}
   public static ProductDto toDto(Product product){
        return ProductDto.builder().
                id(product.getId()).
                name(product.getName()).
                brand(product.getBrand()).
                description(product.getDescription()).
                price(product.getPrice()).
                inventory(product.getInventory()).
                category(CategoryMapper.toDto(product.getCategory())).
                build();
    }
}
