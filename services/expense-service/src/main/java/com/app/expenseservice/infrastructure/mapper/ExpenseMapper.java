package com.app.expenseservice.infrastructure.mapper;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.entity.Expense;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import com.app.expenseservice.infrastructure.persistence.ExpenseJpaEntity;
import org.springframework.stereotype.Component;

@Component
public class ExpenseMapper {

    public Expense toDomain(ExpenseJpaEntity entity) {
        if (entity == null) return null;

        CategoryExpense categoryDomain = null;
        if (entity.getCategoryExpense() != null) {
            categoryDomain = CategoryExpense.restore(
                    entity.getCategoryExpense().getId(),
                    entity.getCategoryExpense().getName(),
                    entity.getCategoryExpense().getIcon(),
                    entity.getCategoryExpense().getCreatedAt(),
                    entity.getCategoryExpense().getUpdatedAt()
            );
        }

        return Expense.restore(
                entity.getId(),
                entity.getAmount(),
                entity.getNote(),
                entity.getTransectionDate(),
                categoryDomain,
                entity.getCreatedAt(),
                entity.getUpdatedAt()
        );
    }

    public ExpenseJpaEntity toJpaEntity(Expense domain, CategoryExpenseJpaEntity categoryJpaEntity) {
        if (domain == null) return null;

        ExpenseJpaEntity entity = new ExpenseJpaEntity();
        entity.setId(domain.getId());
        entity.setAmount(domain.getAmount());
        entity.setNote(domain.getNote());
        entity.setTransectionDate(domain.getTransactionDate());
        entity.setCategoryExpense(categoryJpaEntity);
        entity.setCreatedAt(domain.getCreatedAt());
        entity.setUpdatedAt(domain.getUpdatedAt());

        return entity;
    }
}