package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/test")
    public String test() {
        return "test";
    }
    @GetMapping("")
    public List<Category> getAllCategory() {
        return categoryService.getAllCategory();
    }
    @PostMapping("/add")
    public Category addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }
    @PutMapping("/update")
    public Category updateCategory(@RequestParam("id") int id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }
    @DeleteMapping("/delete/{id}")
    public boolean deleteCategory(@PathVariable("id") int id) {
        return categoryService.deleteCategory(id);
    }
}
