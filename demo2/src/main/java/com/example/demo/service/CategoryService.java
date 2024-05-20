package com.example.demo.service;

import com.example.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    public List<Category> getAllCategory();
    public Category addCategory(Category category);
    public Category updateCategory(int id, Category category);
    public boolean deleteCategory(int id);
}
