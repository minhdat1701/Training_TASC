package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ProductDto> getProductList(String s) {
        String sql = "SELECT * FROM products WHERE name LIKE ?";
        List<ProductDto> list = jdbcTemplate.query(sql, new Object[]{s}, new ProductRowMapper());
        return list;
    }
}
