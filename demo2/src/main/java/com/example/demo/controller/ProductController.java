package com.example.demo.controller;

import com.example.demo.dto.ProductDto;
import com.example.demo.entity.Product;
import com.example.demo.exception.ProductNotFoundException;
import com.example.demo.service.ProductService;
import com.example.demo.spec.ProductSpec;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("")
    public List<ProductDto> getAllProducts() {

        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(name = "id") int id) {
        Product product = productService.getProductById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product not found with id: " + id);
        }
        return ResponseEntity.ok(product);
    }
    @PostMapping("/add")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }
    @PutMapping("/update/{id}")
    public void updateProduct(@PathVariable int id, @RequestBody Product updateProduct) {
        productService.updateProduct(id, updateProduct);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }
    @GetMapping("/search")
    public List<ProductDto> searchProductsByName(@RequestParam("name") String name) {
        Specification<Product> spec = Specification.where(ProductSpec.hasNameLike(name));
        return productService.findProducts(spec);
    }
    @GetMapping("/search/category_name")
    public List<ProductDto> searchByCategoryName(@RequestParam("categoryName") String categoryName) {
        Specification<Product> spec = Specification.where(ProductSpec.hasCategoryName(categoryName));
        return productService.hasCategoryName(spec);
    }
    @GetMapping("/list")
    public List<ProductDto> getProductListByName(@RequestParam("name")String name) {
        String sql = "SELECT * FROM products where name LIKE ?";
        List<ProductDto> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ProductDto.class), "%" + name + "%");
        return list.stream().toList();
    }
    @GetMapping("/get")
    public List<ProductDto> getComic(@RequestParam("s") String s) {
        return productService.getList(s);
    }
}
