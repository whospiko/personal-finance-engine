package com.app.expenseservice.application.handler;

import com.app.expenseservice.application.query.CategoryResult;
import com.app.expenseservice.application.usecase.ExistCategoryUseCase;
import com.app.expenseservice.core.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExistCategoryHandler implements ExistCategoryUseCase {

    private final CategoryRepository categoryRepository;

    @Override
    public boolean execute(CategoryResult result) {
        return categoryRepository.existsById(result.id());
    }
}
