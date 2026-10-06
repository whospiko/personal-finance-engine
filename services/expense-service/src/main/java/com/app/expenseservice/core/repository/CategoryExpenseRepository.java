package com.app.expenseservice.core.repository;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.entity.Expense;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface CategoryExpenseRepository {
    CategoryExpense save(CategoryExpense categoryExpense);
    Optional<CategoryExpense> findById(UUID id);
    List<CategoryExpense> findAll();
}
