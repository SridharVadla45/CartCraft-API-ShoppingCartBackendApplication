package com.sridhar.dev.shopping_cart.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/products",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    // get products
    @GetMapping("/products")
    public String getProducts() {
        return "products";
    }

    // get product

    // create product

    // update product

    // delete product





}
