package com.app.expenseservice.application.handler;

import com.app.common.exception.NotFoundException;
import com.app.expenseservice.application.mapper.CategoryAppMapper;
import com.app.expenseservice.application.query.CategoryResult;
import com.app.expenseservice.application.usecase.GetCategoryUseCase;
import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.presentation.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCategoryHandler implements GetCategoryUseCase {

    private final CategoryExpenseRepository categoryExpenseRepository;
    private final CategoryAppMapper mapper;

    @Override
    public CategoryResponse execute(CategoryResult result) {

        CategoryExpense categoryExpense = categoryExpenseRepository.findById(result.id())
                .orElseThrow(() -> new NotFoundException("Category not found"));

        return mapper.toResponse(categoryExpense);
    }
}
