package com.app.expenseservice.application.handler;

import com.app.expenseservice.application.command.CategoryCreateCommand;
import com.app.expenseservice.application.mapper.CategoryAppMapper;
import com.app.expenseservice.application.usecase.CreateCategoryUseCase;
import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.presentation.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryHandler implements CreateCategoryUseCase {

    private final CategoryExpenseRepository categoryExpenseRepository;
    private final CategoryAppMapper categoryExpenseAppMapper;

    @Override
    public CategoryResponse execute(CategoryCreateCommand command) {

        CategoryExpense categoryExpense = CategoryExpense.create(
                command.name(), command.icon()
        );

        CategoryExpense savedCategoryExpense = categoryExpenseRepository.save(categoryExpense);

        return categoryExpenseAppMapper.toResponse(savedCategoryExpense);
    }
}
