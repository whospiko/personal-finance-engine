package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.query.ExpenseResult;
import com.app.expenseservice.core.entity.Expense;

public interface GetExpenseUseCase {
    Expense execute(ExpenseResult expenseResult);
}
