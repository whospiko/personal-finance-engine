package com.app.expenseservice.application.service;

import com.app.expenseservice.application.dto.CategoryExpenseRequestDto;
import com.app.expenseservice.application.dto.CategoryExpenseResponseDto;
import com.app.expenseservice.application.mapper.CategoryExpenseAppMapper;
import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryExpenseService {

    private final CategoryExpenseRepository categoryExpenseRepository;
    private final CategoryExpenseAppMapper mapper;

    public CategoryExpenseResponseDto create(CategoryExpenseRequestDto dto){
        CategoryExpense categoryExpense = this.mapper.toDomain(dto);
        CategoryExpense savedUser = categoryExpenseRepository.save(categoryExpense);
        return this.mapper.toResponse(savedUser);
    }

}
