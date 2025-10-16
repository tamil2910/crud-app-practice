package com.example.crud_app_practice.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.crud_app_practice.interfaces.ProductServiceInterface;
import com.example.crud_app_practice.models.Category;
import com.example.crud_app_practice.models.Product;
import com.example.crud_app_practice.repositories.CategoryRepository;
import com.example.crud_app_practice.repositories.ProductRepository;

@Service
public class ProductService extends BaseService<Product, Long> implements ProductServiceInterface {
  private final ProductRepository productRepository;
  private final CategoryRepository categoryRepository;

  public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
    super(productRepository);
    this.productRepository = productRepository;
    this.categoryRepository = categoryRepository;
  }

  @Override
  public Product getASingleProduct(Long productId) {
    Optional<Product> product = Optional.ofNullable(productRepository.findProductById(productId));
    return product.orElse(null);
  }

  @Override
  public Product saveASingleProduct(Product product) {

    if(product.getCategory() != null) {
      Category category = product.getCategory();

      // saving new entry
      if(category.getId() == null) {
        category = categoryRepository.save(category);
      }
      else {
        Category exisCategory = categoryRepository.findCategoryById(category.getId());
        if(exisCategory != null) {
          category = exisCategory;
        } else {
          throw new RuntimeException("Category not found with Id of " + category.getId());
        }
      }

      product.setCategory(category);
    }
    return saveAndRefresh(product);
  }

  @Override
  public List<Product> getAllProduct() {
    Optional<List<Product>> product = Optional.ofNullable(this.productRepository.findAll());
    return product.orElse(new ArrayList<>());
  }

}
