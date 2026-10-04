package com.app.expenseservice.application.usecase;

import com.app.expenseservice.presentation.response.CategoryResponse;

import java.util.List;

public interface GetCategoriesUseCase {
    List<CategoryResponse> execute();
}
