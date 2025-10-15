package com.example.crud_app_practice.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud_app_practice.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  Optional<Category> findCategoryById(Long id);
}
