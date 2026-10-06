package com.app.expenseservice.application.handler;

import com.app.common.exception.NotFoundException;
import com.app.expenseservice.application.command.CategoryUpdateCommand;
import com.app.expenseservice.application.mapper.CategoryAppMapper;
import com.app.expenseservice.application.usecase.UpdateCategoryUseCase;
import com.app.expenseservice.core.entity.Category;
import com.app.expenseservice.core.repository.CategoryRepository;
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
    private final CategoryRepository categoryRepository;
    private final CategoryAppMapper mapper;
    private final Logger logger =  LoggerFactory.getLogger(UpdateCategoryHandler.class);

    @Transactional
    @Override
    public CategoryResponse execute(CategoryUpdateCommand command) {
        // Fetch existing domain entity via repository adapter
        Category category = categoryRepository.findById(command.id())
                .orElseThrow(() -> new NotFoundException("CategoryExpense not found with id: " + command.id()));

        logger.info("Update category expense: {}", category);

        // Apply domain mutations
        if (!category.getName().equals(command.name())) {
            category.changeName(command.name());
            logger.info("Update category expense name: {}", category.getName());
        }

        if (!category.getIcon().equals(command.icon())) {
            category.changeIcon(command.icon());
            logger.info("Update category expense icon: {}", category.getIcon());
        }

        logger.info("Updated category expense: {}", category.toString());

        // Save domain entity (updates existing attached/persisted entity in adapter)
        Category updatedCategory = categoryRepository.save(category);

        logger.info("Updated category expense from database: {}", updatedCategory);

        return mapper.toResponse(updatedCategory);
    }
}
