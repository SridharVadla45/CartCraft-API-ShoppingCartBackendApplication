package com.sridhar.dev.shopping_cart.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "product_tbl")
@Data
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String brand;
    private String description;
    private Double price;
    private Integer inventory;

    @OneToMany(mappedBy = "product",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Category.class)
    @JoinColumn(name = "categoryId",referencedColumnName = "id")
    private Category category;

    public Product(String name, String brand, String description, Double price, Integer inventory, Category category) {
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.inventory = inventory;
        this.category = category;
    }
}
