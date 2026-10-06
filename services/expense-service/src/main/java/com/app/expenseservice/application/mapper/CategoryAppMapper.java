package com.app.expenseservice.application.mapper;

import com.app.expenseservice.presentation.response.CategoryResponse;
import com.app.expenseservice.core.entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryAppMapper {

    // toResponse
    public CategoryResponse toResponse(Category domain){
        return new CategoryResponse(
                domain.getId(),
                domain.getName(),
                domain.getIcon(),
                domain.getCreatedAt(),
                domain.getUpdatedAt());
    }

}
