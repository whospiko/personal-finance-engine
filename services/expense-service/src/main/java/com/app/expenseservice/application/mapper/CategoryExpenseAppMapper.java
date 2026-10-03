package com.app.expenseservice.application.mapper;

import com.app.expenseservice.application.dto.CategoryExpenseRequestDto;
import com.app.expenseservice.application.dto.CategoryExpenseResponseDto;
import com.app.expenseservice.core.entity.CategoryExpense;
import org.springframework.stereotype.Component;

@Component
public class CategoryExpenseAppMapper {

    // toDomain
    public CategoryExpense toDomain(CategoryExpenseRequestDto dto){
        CategoryExpense categoryExpense = new CategoryExpense();
        categoryExpense.setName(dto.name());
        categoryExpense.setIcon(dto.icon());
        return categoryExpense;
    }

    // toResponse
    public CategoryExpenseResponseDto toResponse(CategoryExpense domain){
        return new CategoryExpenseResponseDto(
                domain.getId(),
                domain.getName(),
                domain.getIcon(),
                domain.getCreatedAt(),
                domain.getUpdatedAt());
    }

}
