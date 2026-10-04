package com.app.expenseservice.infrastructure.adapter;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.infrastructure.mapper.CategoryExpensePersistenceMapper;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import com.app.expenseservice.infrastructure.persistence.SpringDataJpaCategoryExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryExpenseRepositoryAdapter implements CategoryExpenseRepository {

    private final SpringDataJpaCategoryExpenseRepository categoryExpenseRepository;
    private final CategoryExpensePersistenceMapper mapper;

    @Override
    public CategoryExpense save(CategoryExpense categoryExpense) {
        CategoryExpenseJpaEntity entity = mapper.toEntity(categoryExpense);
        CategoryExpenseJpaEntity savedEntity = categoryExpenseRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<CategoryExpense> findById(UUID id) {
        return Optional.empty();
    }
}