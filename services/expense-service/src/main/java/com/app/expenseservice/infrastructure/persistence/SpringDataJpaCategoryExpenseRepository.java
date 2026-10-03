package com.app.expenseservice.infrastructure.persistence;

import com.app.expenseservice.core.entity.CategoryExpense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataJpaCategoryExpenseRepository extends JpaRepository<CategoryExpenseJpaEntity, UUID> {
}
