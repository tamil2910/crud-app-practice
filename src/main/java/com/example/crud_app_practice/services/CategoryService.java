package com.example.crud_app_practice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.crud_app_practice.models.Category;
import org.springframework.stereotype.Service;

import com.example.crud_app_practice.interfaces.CategoryServiceInterface;
import com.example.crud_app_practice.repositories.CategoryRepository;

@Service
public class CategoryService extends BaseService<Category, Long> implements CategoryServiceInterface {
  CategoryRepository categoryRepository;

  CategoryService(CategoryRepository categoryRepository) {
    super(categoryRepository);
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Category getASingleCategory(Long categoryId) {
    return this.categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
    // return category != null ? category: null;
  }

  @Override
  public Category saveASingleCategory(Category category) {
    return saveAndRefresh(category); // save and refresh forcefully that record to get sub table data
  }

  @Override
  public List<Category> getAllCategory() {
    Optional<List<Category>> categories = Optional.ofNullable(this.categoryRepository.findAll());
    return categories.orElse(new ArrayList<>());
  }

  @Override
  public Category updateASinglCategory(Category category, Long categoryId) {
    return null;
  }

}
