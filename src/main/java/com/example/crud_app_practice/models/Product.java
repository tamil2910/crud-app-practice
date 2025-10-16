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

  @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER) // category will be synced if available category id in category table by using cascade = CascadeType.Merge, new will be created if no id by CascadeType.PERSIST
  @JoinColumn(name = "category_id")
  private Category category;
}
