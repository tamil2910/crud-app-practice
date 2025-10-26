package com.example.crud_app_practice.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_app_practice.models.Category;
import com.example.crud_app_practice.response_setups.ApiResponse;
import com.example.crud_app_practice.services.CategoryService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/categories")
public class CategoryController {
  private final CategoryService categoryService;

  CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @PostMapping("/")
  public ApiResponse<Category> saveSingleCategory(@Valid @RequestBody Category data) {
    Category savCategory = this.categoryService.saveASingleCategory(data);

    if (savCategory != null) {
      return new ApiResponse<>(true, "Success", savCategory);
    } else {
      return new ApiResponse<>(false, "Failed to save category", null);
    }
  }

  @GetMapping("/{id}")
  public ApiResponse<Category> getASingleCategory(@PathVariable("id") Long id) {
    Category category = this.categoryService.getASingleCategory(id);

    if (category != null) {
      return new ApiResponse<>(true, "Success", category);
    } else {
      return new ApiResponse<>(false, "Category not found", null);
    }
    
  }

  @GetMapping("/")
  public ApiResponse<List<Category>> getAllCategory() {
    List<Category> category = categoryService.getAllCategory();
    return new ApiResponse<>(true, "Success", category);
  }
}
