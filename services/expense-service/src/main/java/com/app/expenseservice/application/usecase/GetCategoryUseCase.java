package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.query.CategoryResult;
import com.app.expenseservice.presentation.response.CategoryResponse;

public interface GetCategoryUseCase {
    CategoryResponse execute(CategoryResult result);
}
