package com.sridhar.dev.shopping_cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category_tbl")
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
    private List<Product> productList;

    public Category(String name, String description) {
    }
}
