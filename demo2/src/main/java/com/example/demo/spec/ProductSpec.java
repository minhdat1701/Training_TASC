package com.example.demo.spec;

import com.example.demo.entity.Category;
import com.example.demo.entity.Product;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

public class ProductSpec {
    public static Specification<Product> hasNameLike(String name) {
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.<String>get("name"), name));
    }
    public static Specification<Product> hasCategoryName(String categoryName) {
        return ((root, query, criteriaBuilder) -> {
            Join<Category, Product> departmentProduct = root.join("category");
            return criteriaBuilder.equal(departmentProduct.get("name"), categoryName);
        });
    }
//    public static Specification<Product>  greaterThanAge(int priceProduct) {
//        return (((root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), priceProduct)));
//    }
}
