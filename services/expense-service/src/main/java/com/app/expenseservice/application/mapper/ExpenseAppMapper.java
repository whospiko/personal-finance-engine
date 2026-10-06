package com.app.expenseservice.application.mapper;

import com.app.expenseservice.core.entity.Expense;
import com.app.expenseservice.presentation.response.ExpenseResponse;
import org.springframework.stereotype.Component;

@Component
public class ExpenseAppMapper {

    // toResponse
    public ExpenseResponse toResponse(Expense domain){
        return new ExpenseResponse(
                domain.getId(),
                domain.getAmount());
    }
}
