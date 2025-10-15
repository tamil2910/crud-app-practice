package com.example.crud_app_practice.controllers;

import java.util.List;
import com.example.crud_app_practice.response_setups.ApiResponse;
import com.example.crud_app_practice.services.ProductService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud_app_practice.models.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

  private final ProductService productService;

  ProductController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping("/{id}")
  public ApiResponse<Product> getSingleProduct(@PathVariable("id") Long id) {
    Product product = productService.getASingleProduct(id);

    if (product != null) {
      return new ApiResponse<>(true, "Success", product);
    } else {
      return new ApiResponse<>(false, "Product not found", null);
    }
  }

  @PostMapping("/")
  public ApiResponse<Product> saveSingleProduct(@RequestBody Product data) {
    Product saveProduct = productService.saveASingleProduct(data);

    if(saveProduct != null) {
      return new ApiResponse<>(true, "Success", saveProduct);
    } else {
      return new ApiResponse<>(false, "Failed to save product", null);
    }
  }
  
  @GetMapping("/")
  public ApiResponse<List<Product>> getAllProduct() {
    List<Product> products = productService.getAllProduct();
    
    ApiResponse<List<Product>> response = new ApiResponse<>(true, "Success", products);
    return response;
  }
}
