package com.sridhar.dev.shopping_cart.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {

    private Long id;
    private String name;
    private String brand;
    private String description;
    private Double price;
    private Integer inventory;
    private CategoryDto categoryDto;
}
