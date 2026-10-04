package com.app.expenseservice.application.handler;

import com.app.expenseservice.application.mapper.CategoryAppMapper;
import com.app.expenseservice.application.usecase.GetCategoriesUseCase;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.presentation.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCategoriesHandler implements GetCategoriesUseCase {

    private final CategoryExpenseRepository categoryExpenseRepository;
    private final CategoryAppMapper mapper;


    @Override
    public List<CategoryResponse> execute() {
        return categoryExpenseRepository.findAll().stream().map(mapper::toResponse).toList();
    }
}
