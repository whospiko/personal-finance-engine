package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.command.CategoryExpenseCreateCommand;
import com.app.expenseservice.presentation.response.CategoryExpenseResponse;

public interface CreateCategoryExpenseUseCase {
    CategoryExpenseResponse execute(CategoryExpenseCreateCommand command);
}
