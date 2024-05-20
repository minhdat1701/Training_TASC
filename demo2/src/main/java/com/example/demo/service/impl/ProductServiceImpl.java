package com.example.demo.service.impl;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductJdbcRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ProductJdbcRepository productJdbcRepository;
    @Override
    public List<ProductDto> getAllProducts() {
        return productRepository.findAll().stream()
                .map(product -> {
                    ProductDto productDto = modelMapper.map(product, ProductDto.class);
                    if (product.getCategory() != null) {
                        productDto.setCategory_id(product.getCategory().getId());
                    } else {
                        productDto.setCategory_id(null);
                    }
                    return productDto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }
    @Override
    public void updateProduct(int id, Product updateProduct) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct == null) {
            throw new ProductNotFoundException("Not found product");
        }
        existingProduct.setName(updateProduct.getName());
        existingProduct.setDescription(updateProduct.getDescription());
        existingProduct.setPrice(updateProduct.getPrice());
        existingProduct.setCategory(updateProduct.getCategory());
        productRepository.save(updateProduct);
    }
    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
    @Override
    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }
    @Override
    public List<ProductDto> findProducts(Specification<Product> spec) {
        return productRepository.findAll(spec).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
    public List<ProductDto> hasCategoryName(Specification<Product> spec) {
        return productRepository.findAll(spec).stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }
    public List<ProductDto> getList() {
        return productJdbcRepository.getProductList();
    }
}
