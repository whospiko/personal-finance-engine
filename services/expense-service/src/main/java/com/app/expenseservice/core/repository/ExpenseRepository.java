package com.app.expenseservice.core.repository;

import com.app.expenseservice.core.entity.Expense;

import java.util.Optional;
import java.util.UUID;

public interface ExpenseRepository {
    Expense save(Expense expense);
    Optional<Expense> findById(UUID id);
}
