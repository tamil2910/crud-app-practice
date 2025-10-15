package com.example.crud_app_practice.interfaces;

import java.util.List;
import com.example.crud_app_practice.models.Category;

public interface CategoryServiceInterface {
  Category getASingleCategory(Long categoryId);
  Category saveASingleCategory(Category category);
  List<Category> getAllCategory();
  Category updateASinglCategory(Category category, Long categoryId);
}
