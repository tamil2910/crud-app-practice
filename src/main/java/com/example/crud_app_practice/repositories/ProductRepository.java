package com.example.crud_app_practice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud_app_practice.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
  Product findProductById(Long id);
}
