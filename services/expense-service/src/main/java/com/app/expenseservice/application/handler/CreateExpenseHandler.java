package com.app.expenseservice.application.handler;

import com.app.common.exception.NotFoundException;
import com.app.expenseservice.application.command.CreateExpenseCommand;
import com.app.expenseservice.application.mapper.ExpenseAppMapper;
import com.app.expenseservice.application.usecase.CreateExpenseUseCase;
import com.app.expenseservice.core.entity.Category;
import com.app.expenseservice.core.entity.Expense;
import com.app.expenseservice.core.repository.CategoryRepository;
import com.app.expenseservice.core.repository.ExpenseRepository;
import com.app.expenseservice.presentation.response.ExpenseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreateExpenseHandler implements CreateExpenseUseCase {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final ExpenseAppMapper expenseAppMapper;

    @Override
    @Transactional
    public ExpenseResponse execute(CreateExpenseCommand command) {

        Category category = categoryRepository.findById(command.categoryId())
                .orElseThrow(() -> new NotFoundException("Category not found"));

        Expense expense = Expense.create(
                        command.amount(),
                        command.note(),
                        category
                );

        Expense savedExpense = expenseRepository.save(expense);

        return expenseAppMapper.toResponse(savedExpense);
    }
}
