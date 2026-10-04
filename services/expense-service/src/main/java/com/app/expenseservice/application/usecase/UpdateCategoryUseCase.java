package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.command.CategoryUpdateCommand;
import com.app.expenseservice.presentation.response.CategoryResponse;

public interface UpdateCategoryUseCase {
    CategoryResponse execute(CategoryUpdateCommand command);
}
