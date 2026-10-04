package com.app.expenseservice.application.handler;

import com.app.common.exception.NotFoundException;
import com.app.expenseservice.application.command.CategoryUpdateCommand;
import com.app.expenseservice.application.mapper.CategoryAppMapper;
import com.app.expenseservice.application.usecase.UpdateCategoryUseCase;
import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.presentation.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UpdateCategoryHandler implements UpdateCategoryUseCase {
    private final CategoryExpenseRepository categoryExpenseRepository;
    private final CategoryAppMapper mapper;
    private final Logger logger =  LoggerFactory.getLogger(UpdateCategoryHandler.class);

    @Transactional
    @Override
    public CategoryResponse execute(CategoryUpdateCommand command) {
        // Fetch existing domain entity via repository adapter
        CategoryExpense categoryExpense = categoryExpenseRepository.findById(command.id())
                .orElseThrow(() -> new NotFoundException("CategoryExpense not found with id: " + command.id()));

        logger.info("Update category expense: {}", categoryExpense);

        // Apply domain mutations
        if (!categoryExpense.getName().equals(command.name())) {
            categoryExpense.changeName(command.name());
            logger.info("Update category expense name: {}", categoryExpense.getName());
        }

        if (!categoryExpense.getIcon().equals(command.icon())) {
            categoryExpense.changeIcon(command.icon());
            logger.info("Update category expense icon: {}", categoryExpense.getIcon());
        }

        logger.info("Updated category expense: {}", categoryExpense.toString());

        // Save domain entity (updates existing attached/persisted entity in adapter)
        CategoryExpense updatedCategory = categoryExpenseRepository.save(categoryExpense);

        logger.info("Updated category expense from database: {}", updatedCategory);

        return mapper.toResponse(updatedCategory);
    }
}
