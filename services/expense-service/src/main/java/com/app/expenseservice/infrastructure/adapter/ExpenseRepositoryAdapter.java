package com.app.expenseservice.infrastructure.adapter;

import com.app.expenseservice.core.entity.Expense;
import com.app.expenseservice.core.repository.ExpenseRepository;
import com.app.expenseservice.infrastructure.mapper.ExpensePersistenceMapper;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import com.app.expenseservice.infrastructure.persistence.ExpenseJpaEntity;
import com.app.expenseservice.infrastructure.persistence.SpringDataExpenseRepository;
import com.app.expenseservice.infrastructure.persistence.SpringDataJpaCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ExpenseRepositoryAdapter implements ExpenseRepository {

    private final SpringDataExpenseRepository jpaExpenseRepository;
    private final SpringDataJpaCategoryRepository jpaCategoryRepository;
    private final ExpensePersistenceMapper expenseMapper;

    @Override
    public Expense save(Expense domainExpense) {
        CategoryExpenseJpaEntity categoryJpa = jpaCategoryRepository.findById(domainExpense.getCategory().getId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found with ID: " + domainExpense.getCategory().getId()));

        ExpenseJpaEntity jpaEntity = expenseMapper.toJpaEntity(domainExpense, categoryJpa);
        ExpenseJpaEntity savedEntity = jpaExpenseRepository.save(jpaEntity);

        return expenseMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Expense> findById(UUID id) {
        return jpaExpenseRepository.findByIdWithCategory(id)
                .map(expenseMapper::toDomain);
    }
}