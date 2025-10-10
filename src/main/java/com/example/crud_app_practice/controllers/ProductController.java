package com.example.crud_app_practice.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_app_practice.models.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

  @GetMapping("/")
  public Product getSingleProduct() {
    return new Product();
  }
  
  @GetMapping("/")
  public List<Product> getAllProduct() {
    return new ArrayList<>();
  }
}
