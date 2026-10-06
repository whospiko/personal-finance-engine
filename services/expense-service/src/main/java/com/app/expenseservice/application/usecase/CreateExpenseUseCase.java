package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.command.CreateExpenseCommand;
import com.app.expenseservice.presentation.response.ExpenseResponse;

public interface CreateExpenseUseCase {
    ExpenseResponse execute(CreateExpenseCommand command);
}
