package com.sridhar.dev.shopping_cart.dto;

import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.entity.Image;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProductDto {

    private Long Id;
    private String name;
    private String brand;
    private String description;
    private Double price;
    private Integer inventory;

    private Category category;
}
