package com.app.expenseservice.application.handler;

import com.app.expenseservice.application.command.CategoryExpenseCreateCommand;
import com.app.expenseservice.application.mapper.CategoryExpenseAppMapper;
import com.app.expenseservice.application.usecase.CreateCategoryExpenseUseCase;
import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.presentation.response.CategoryExpenseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryExpenseHandler implements CreateCategoryExpenseUseCase {

    private final CategoryExpenseRepository categoryExpenseRepository;
    private final CategoryExpenseAppMapper categoryExpenseAppMapper;

    @Override
    public CategoryExpenseResponse execute(CategoryExpenseCreateCommand command) {

        CategoryExpense categoryExpense = CategoryExpense.create(
                command.name(), command.icon()
        );

        CategoryExpense savedCategoryExpense = categoryExpenseRepository.save(categoryExpense);

        return categoryExpenseAppMapper.toResponse(savedCategoryExpense);
    }
}
