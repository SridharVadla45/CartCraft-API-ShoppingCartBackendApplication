package com.sridhar.dev.shopping_cart.dto;

import com.sridhar.dev.shopping_cart.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {

    private Long id;
    private String name;
    private String brand;
    private String description;
    private Double price;
    private Integer inventory;
    private CategoryDto category;
}
