package com.app.expenseservice.application.handler;

import com.app.common.exception.NotFoundException;
import com.app.expenseservice.application.query.ExpenseResult;
import com.app.expenseservice.application.usecase.GetExpenseUseCase;
import com.app.expenseservice.core.entity.Expense;
import com.app.expenseservice.core.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetExpenseHandler implements GetExpenseUseCase {
    private final ExpenseRepository expenseRepository;
    @Override
    public Expense execute(ExpenseResult expenseResult) {
        return expenseRepository.findById(expenseResult.id()).orElseThrow(
                ()-> new NotFoundException("Expense with id: " + expenseResult.id())
        );
    }
}
