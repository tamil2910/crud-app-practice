package com.example.crud_app_practice.interfaces;

import java.util.List;

import com.example.crud_app_practice.models.Product;

public interface ProductServiceInterface {
  Product getASingleProduct(Long productId);
  List<Product> getAllProduct();

  Product saveASingleProduct(Product product);
}
