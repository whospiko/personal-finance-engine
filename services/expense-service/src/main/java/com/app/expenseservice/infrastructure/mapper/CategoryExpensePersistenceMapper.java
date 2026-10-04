package com.app.expenseservice.infrastructure.mapper;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryExpensePersistenceMapper {

    public CategoryExpenseJpaEntity toEntity(CategoryExpense domain) {
        CategoryExpenseJpaEntity categoryExpenseJpaEntity = new CategoryExpenseJpaEntity();

        categoryExpenseJpaEntity.setId(domain.getId());
        categoryExpenseJpaEntity.setName(domain.getName());
        categoryExpenseJpaEntity.setIcon(domain.getIcon());

        return categoryExpenseJpaEntity;
    }

    public CategoryExpense toDomain(CategoryExpenseJpaEntity entity) {
        return CategoryExpense.restore(
                entity.getId(),
                entity.getName(),
                entity.getIcon(),
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }
}
