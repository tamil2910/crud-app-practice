package com.example.crud_app_practice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "categories")
public class Category extends BaseModel{

  @Size(min = 2, max = 50, message = "Name must be between 2 to 50 characters")
  private String name;
  
  @NotBlank(message = "Description is required")
  private String description;
}
