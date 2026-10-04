package com.app.expenseservice.application.mapper;

import com.app.expenseservice.presentation.response.CategoryExpenseResponse;
import com.app.expenseservice.core.entity.CategoryExpense;
import org.springframework.stereotype.Component;

@Component
public class CategoryExpenseAppMapper {

    // toResponse
    public CategoryExpenseResponse toResponse(CategoryExpense domain){
        return new CategoryExpenseResponse(
                domain.getId(),
                domain.getName(),
                domain.getIcon(),
                domain.getCreatedAt(),
                domain.getUpdatedAt());
    }

}
