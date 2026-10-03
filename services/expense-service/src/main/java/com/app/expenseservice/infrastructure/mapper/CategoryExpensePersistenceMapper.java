package com.app.expenseservice.infrastructure.mapper;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryExpensePersistenceMapper {

    public CategoryExpenseJpaEntity toEntity(CategoryExpense categoryExpense) {
        CategoryExpenseJpaEntity categoryExpenseJpaEntity = new CategoryExpenseJpaEntity();
        categoryExpenseJpaEntity.setId(categoryExpense.getId());
        categoryExpenseJpaEntity.setName(categoryExpense.getName());
        categoryExpenseJpaEntity.setIcon(categoryExpense.getIcon());
        return categoryExpenseJpaEntity;
    }

    public CategoryExpense toDomain(CategoryExpenseJpaEntity categoryExpenseJpaEntity) {
        CategoryExpense categoryExpense = new CategoryExpense();
        categoryExpense.setId(categoryExpenseJpaEntity.getId());
        categoryExpense.setName(categoryExpenseJpaEntity.getName());
        categoryExpense.setIcon(categoryExpenseJpaEntity.getIcon());
        categoryExpense.setCreatedAt(categoryExpenseJpaEntity.getCreatedAt());
        categoryExpense.setUpdatedAt(categoryExpenseJpaEntity.getUpdatedAt());
        return categoryExpense;
    }
}
