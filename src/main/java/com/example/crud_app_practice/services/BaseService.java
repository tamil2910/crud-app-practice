package com.example.crud_app_practice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

@Transactional
public abstract class BaseService<T, ID> {
  protected final JpaRepository<T, ID> repository;

  protected BaseService(JpaRepository<T, ID> repository) {
    this.repository = repository;
  }

  public T saveAndRefresh(T entity) {
    T savedEntity = repository.save(entity);
    repository.flush(); // forcefully refresh
    return savedEntity;
  }

  public Optional<T> findById(ID id) {
    return repository.findById(id);
  }

  public List<T> findAll() {
    return this.repository.findAll();
  }

}
