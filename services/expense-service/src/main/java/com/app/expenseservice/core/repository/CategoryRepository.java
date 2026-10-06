package com.app.expenseservice.core.repository;

import com.app.expenseservice.core.entity.Category;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CategoryRepository {
    Category save(Category category);
    Optional<Category> findById(UUID id);
    List<Category> findAll();
    Boolean existsById(UUID id);
}
