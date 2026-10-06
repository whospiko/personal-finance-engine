package com.app.expenseservice.application.usecase;

import com.app.expenseservice.application.query.CategoryResult;

public interface ExistCategoryUseCase {
    boolean execute(CategoryResult result);
}
