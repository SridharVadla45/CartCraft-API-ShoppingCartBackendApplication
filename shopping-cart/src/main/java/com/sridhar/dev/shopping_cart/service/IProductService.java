package com.sridhar.dev.shopping_cart.service;

import com.sridhar.dev.shopping_cart.dto.ProductDto;
import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();
    Product getProduct(Long id);
    Product createProduct(ProductDto product);
    Product updateProduct(Long id, ProductDto product);
    void deleteProduct(Long id);
    List<Product> getProductsByCategory(Category category);
    List<Product> getProductsByBrand(String brand);
    List<Product> getProductsByCategoryAndBrand(Category category, String brand);
    List<Product> searchProducts(String keyword);
}
