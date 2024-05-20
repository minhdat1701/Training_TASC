package com.example.demo.service.impl;

import com.example.demo.entity.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category category) {
        if (category != null) {
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Category updateCategory(int id, Category category) {
        if (category != null) {
            Category category1 = categoryRepository.getById(id);
            if (category1 != null ) {
                category1.setName(category.getName());
                category1.setDescription(category.getDescription());
                return categoryRepository.save(category1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteCategory(int id) {
        Category category = categoryRepository.getById(id);
        if (category != null) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
