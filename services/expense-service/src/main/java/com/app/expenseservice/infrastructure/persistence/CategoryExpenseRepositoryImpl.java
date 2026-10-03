package com.app.expenseservice.infrastructure.persistence;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.infrastructure.mapper.CategoryExpensePersistenceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CategoryExpenseRepositoryImpl implements CategoryExpenseRepository {

    private final SpringDataJpaCategoryExpenseRepository jpaCategoryExpenseRepository;
    private final CategoryExpensePersistenceMapper mapper;

    @Override
    public CategoryExpense save(CategoryExpense categoryExpense) {

       CategoryExpenseJpaEntity entity =  this.mapper.toEntity(categoryExpense);

       entity =  this.jpaCategoryExpenseRepository.save(entity);

        return this.mapper.toDomain(entity);
    }

    @Override
    public Optional<CategoryExpense> findById(UUID id) {
        return Optional.empty();
    }
}
