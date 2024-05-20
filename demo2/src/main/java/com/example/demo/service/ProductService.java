package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProducts();
    void addProduct(Product product);
    void updateProduct(int id, Product product);
    void deleteProduct(int id);
    Product getProductById(int id);
    List<ProductDto> findProducts(Specification<Product> spec);
    List<ProductDto> hasCategoryName(Specification<Product> spec);
    List<ProductDto> getList();
}
