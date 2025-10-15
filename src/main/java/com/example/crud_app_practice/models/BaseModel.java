package com.example.crud_app_practice.models;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id; // Auto-increment
  private Date created_at;
  private Date updated_at;

  @PrePersist
  protected void prePersist() {
    this.created_at = new Date();
    this.updated_at = new Date();
  }

  @PreUpdate
  protected void PreUpdate() {
    this.updated_at = new Date();
  }
}
