package com.app.expenseservice.application.handler;

import com.app.expenseservice.application.command.CategoryCreateCommand;
import com.app.expenseservice.application.mapper.CategoryAppMapper;
import com.app.expenseservice.application.usecase.CreateCategoryUseCase;
import com.app.expenseservice.core.entity.Category;
import com.app.expenseservice.core.repository.CategoryRepository;
import com.app.expenseservice.presentation.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateCategoryHandler implements CreateCategoryUseCase {

    private final CategoryRepository categoryRepository;
    private final CategoryAppMapper categoryExpenseAppMapper;

    @Override
    public CategoryResponse execute(CategoryCreateCommand command) {

        Category category = Category.create(
                command.name(), command.icon()
        );

        Category savedCategory = categoryRepository.save(category);

        return categoryExpenseAppMapper.toResponse(savedCategory);
    }
}
