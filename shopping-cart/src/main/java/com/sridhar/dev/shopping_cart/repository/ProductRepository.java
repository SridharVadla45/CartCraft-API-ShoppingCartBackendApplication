package com.sridhar.dev.shopping_cart.repository;

import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

    List<Product> findByBrand(String brand);

    List<Product> findByBrandAndCategory(Category category, String brand);

    List<Product> findByNameContaining(String keyword);
}
