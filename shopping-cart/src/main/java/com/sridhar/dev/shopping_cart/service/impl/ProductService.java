package com.sridhar.dev.shopping_cart.service.impl;

import com.sridhar.dev.shopping_cart.dto.ProductDto;
import com.sridhar.dev.shopping_cart.entity.Category;
import com.sridhar.dev.shopping_cart.entity.Product;
import com.sridhar.dev.shopping_cart.exception.ResourceNotFoundException;
import com.sridhar.dev.shopping_cart.mapper.ProductMapper;
import com.sridhar.dev.shopping_cart.repository.CategoryRepository;
import com.sridhar.dev.shopping_cart.repository.ProductRepository;
import com.sridhar.dev.shopping_cart.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(
                ProductMapper::toDto
        ).collect(Collectors.toList());
    }

    @Override
    public ProductDto getProduct(Long id) {
        return ProductMapper.toDto(
                productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", id))
        );
    }

    @Override
    public ProductDto createProduct(ProductDto product) {
        //check for category if exist or not
        Category category = categoryRepository.findByName(product.getCategoryDto().getName()).orElseGet(() -> categoryRepository.save(new Category(product.getCategoryDto().getName(), product.getCategoryDto().getDescription())));
        Product product1 = new Product(product.getName(), product.getBrand(), product.getDescription(), product.getPrice(), product.getInventory(), category);
        return ProductMapper.toDto(productRepository.save(product1));
    }

    @Override
    public ProductDto updateProduct(Long id, ProductDto productDto) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "productId", id));

        Category category = categoryRepository.findByName(productDto.getCategoryDto().getName()).orElseGet(() -> categoryRepository.save(new Category(productDto.getCategoryDto().getName(), productDto.getCategoryDto().getDescription())));

        existingProduct.setName(productDto.getName());
        existingProduct.setBrand(productDto.getBrand());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setInventory(productDto.getInventory());
        existingProduct.setCategory(category);

        return ProductMapper.toDto(productRepository.save(existingProduct));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.findById(id).ifPresentOrElse(productRepository::delete, () -> {
            throw new ResourceNotFoundException("Product", "productId", id);
        });
    }


//    public List<Product> getProductsByCategory(Category category) {
//        return productRepository.findByCategory(category);
//    }


    public List<Product> getProductsByBrand(String brand) {
        return productRepository.findByBrand(brand);
    }


//    public List<Product> getProductsByCategoryAndBrand(Category category, String brand) {
//        return productRepository.findByBrandAndCategory(category, brand);
//    }


    public List<Product> searchProducts(String keyword) {
        return productRepository.findByNameContaining(keyword);
    }
}
