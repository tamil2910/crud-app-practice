package com.example.crud_app_practice.models;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Category extends BaseModel{

  @NotBlank(message = "Name is required")
  @Size(min = 2, max = 50, message = "Name must be between 2 to 50 characters")
  private String name;
  
  private String description;
}
