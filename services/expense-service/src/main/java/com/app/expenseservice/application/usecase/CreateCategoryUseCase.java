package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.command.CategoryCreateCommand;
import com.app.expenseservice.presentation.response.CategoryResponse;

public interface CreateCategoryUseCase {
    CategoryResponse execute(CategoryCreateCommand command);
}
