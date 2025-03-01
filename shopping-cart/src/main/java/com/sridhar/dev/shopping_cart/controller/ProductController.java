package com.sridhar.dev.shopping_cart.controller;

import com.sridhar.dev.shopping_cart.dto.ProductDto;
import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.entity.Product;
import com.sridhar.dev.shopping_cart.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)

public class ProductController {

    @Autowired
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // get products
    @GetMapping
    public ResponseEntity<Object> getProducts() {
        List<Product> products = productService.getProducts();
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

    // get product
    @GetMapping("/{id}")
    public ResponseEntity<Object> getProduct(@PathVariable Long id) {
        Product product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }

    // create product
    @PostMapping
    public ResponseEntity<Object> createProduct(@RequestBody ProductDto product) {
        Product newProduct = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    // update product
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable Long id, @RequestBody ProductDto product) {
        Product updatedProduct = productService.updateProduct(id, product);
        return ResponseEntity.ok(updatedProduct);
    }

    // delete product

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }


//    @GetMapping("/category")
//    public ResponseEntity<Object> getProductsByCategory(@RequestBody Category category) {
//        List<Product> products = productService.getProductsByCategory(category);
//        if (products.isEmpty()) return ResponseEntity.noContent().build();
//        return ResponseEntity.ok(products);
//    }


    @GetMapping("/brand")
    public ResponseEntity<Object> getProductsByBrand(@RequestBody String brand) {
        List<Product> products = productService.getProductsByBrand(brand);
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }

//    @GetMapping("/category/{brand}")
//    public ResponseEntity<Object> getProductsByCategoryAndBrand(@RequestBody Category category, @PathVariable String brand) {
//        List<Product> products = productService.getProductsByCategoryAndBrand(category, brand);
//        if (products.isEmpty()) return ResponseEntity.noContent().build();
//        return ResponseEntity.ok(products);
//    }

    //
    @GetMapping("/search/{keyword}")
    public ResponseEntity<Object> searchProducts(@PathVariable String keyword) {
        List<Product> products = productService.searchProducts(keyword);
        if (products.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(products);
    }


}
