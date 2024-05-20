package com.example.demo.repository;

import com.example.demo.dto.ProductDto;
import com.example.demo.mapper.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ProductJdbcRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//    public List<ProductDto> getProductList() {
//        String sql = "SELECT * FROM products WHERE name LIKE ?";
//        List<ProductDto> list = jdbcTemplate.query(sql, new Object[]{"%Truyen%"}, new ProductRowMapper());
//        return list;
//    }
    public List<ProductDto> getProductList() {
        String sql = "SELECT * FROM products WHERE name LIKE :name";
        MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("name", "%Truyen%");

        return namedParameterJdbcTemplate.query(sql, parameters, new ProductRowMapper());
    }
}
