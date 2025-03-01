package com.sridhar.dev.shopping_cart.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images_tbl")
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;

    @Lob
    private byte[] data;

    @ManyToOne(targetEntity = Product.class)
    @JoinColumn(name = "product_id",referencedColumnName = "id")
    private Product product;
}
