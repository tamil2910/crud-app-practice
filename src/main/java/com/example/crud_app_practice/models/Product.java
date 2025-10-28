package com.example.crud_app_practice.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
// @Table(name = "products")
public class Product extends BaseModel {
  @NotBlank(message = "Title is required")
  @Size(min = 2, max = 50, message = "Title must be between 2 to 50 characters")
  private String title;

  @NotNull(message = "Price is required")
  @Positive(message = "Price must be positive number")
  private double price;

  @Valid // cascade validation to the related validations
  @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}, fetch = FetchType.EAGER) // category will be synced if available category id in category table by using cascade = CascadeType.Merge, new will be created if no id by CascadeType.PERSIST
  @JoinColumn(name = "category_id")
  private Category category;
}
