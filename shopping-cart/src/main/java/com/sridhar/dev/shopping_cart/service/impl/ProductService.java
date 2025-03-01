package com.sridhar.dev.shopping_cart.service.impl;

import ch.qos.logback.classic.spi.IThrowableProxy;
import com.sridhar.dev.shopping_cart.dto.ProductDto;
import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.entity.Product;
import com.sridhar.dev.shopping_cart.exception.ResourceNotFoundException;
import com.sridhar.dev.shopping_cart.repository.CategoryRepository;
import com.sridhar.dev.shopping_cart.repository.ProductRepository;
import com.sridhar.dev.shopping_cart.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;


    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->  new ResourceNotFoundException("Product", "productId", id));
    }

    @Override
    public Product createProduct(ProductDto product) {
        //check for category if exist or not
        Category category = categoryRepository.findByName(product.getCategory().getName())
                .orElseGet(() ->  categoryRepository.save(
                            new Category(product.getCategory().getName(), product.getCategory().getDescription())));
        Product product1 = new Product(product.getName(), product.getBrand(), product.getDescription(), product.getPrice(), product.getInventory(), category);
        return productRepository.save(product1);
    }
    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product", "productId", id));

        Category category = categoryRepository.findByName(productDto.getCategory().getName())
                .orElseGet(() -> categoryRepository.save(
                        new Category(productDto.getCategory().getName(), productDto.getCategory().getDescription())));

        existingProduct.setName(productDto.getName());
        existingProduct.setBrand(productDto.getBrand());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setInventory(productDto.getInventory());
        existingProduct.setCategory(category);

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete,
                () -> {throw new ResourceNotFoundException("Product", "productId", id);});
        ;
    }


    public List<Product> getProductsByCategory(Category category) {
        return productRepository.findByCategory(category);
    }


    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }


    public List<Product> getProductsByCategoryAndBrand(Category category, String brand) {
        return productRepository.findByBrandAndCategory(category, brand);
    }


    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }
}
