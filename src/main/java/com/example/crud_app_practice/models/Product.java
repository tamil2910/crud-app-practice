package com.example.crud_app_practice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends BaseModel {
  private String title;
  private double price;

  @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER) // category will be added if not available in category id in category table by using cascade = CascadeType.PERSIST
  @JoinColumn(name = "category_id")
  private Category category;
}
