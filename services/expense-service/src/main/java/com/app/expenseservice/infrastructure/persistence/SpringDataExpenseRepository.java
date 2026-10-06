package com.app.expenseservice.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataExpenseRepository extends JpaRepository<ExpenseJpaEntity, UUID> {

    @Query("SELECT e FROM ExpenseJpaEntity e " +
            "JOIN FETCH e.categoryExpense WHERE e.id = :id")
    Optional<ExpenseJpaEntity> findByIdWithCategory(@Param("id") UUID id);
}
