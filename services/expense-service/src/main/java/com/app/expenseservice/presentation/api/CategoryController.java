package com.app.expenseservice.presentation.api;

import com.app.common.dto.ApiResponse;
import com.app.expenseservice.application.command.CategoryCreateCommand;
import com.app.expenseservice.application.command.CategoryUpdateCommand;
import com.app.expenseservice.application.query.CategoryResult;
import com.app.expenseservice.application.usecase.CreateCategoryUseCase;
import com.app.expenseservice.application.usecase.GetCategoriesUseCase;
import com.app.expenseservice.application.usecase.GetCategoryUseCase;
import com.app.expenseservice.application.usecase.UpdateCategoryUseCase;
import com.app.expenseservice.presentation.request.CategoryRequest;
import com.app.expenseservice.presentation.response.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryExpenseUseCase;
    private final GetCategoryUseCase getCategoryUseCase;
    private final GetCategoriesUseCase getCategoriesUseCase;
    private final UpdateCategoryUseCase updateCategoryUseCase;

    @PostMapping()
    public ApiResponse<CategoryResponse> create(
            @Valid
            @RequestBody CategoryRequest request) {

        CategoryResponse response = createCategoryExpenseUseCase.execute(new CategoryCreateCommand(
                request.name(),
                request.icon()
        ));

        return ApiResponse.success(response);
    }

    @GetMapping()
    public ApiResponse<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> responses = getCategoriesUseCase.execute();
        return ApiResponse.success(responses);
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponse> updateUser(
            @PathVariable UUID id) {

        CategoryResponse response = getCategoryUseCase.execute(
                new CategoryResult(id)
        );

        return ApiResponse.success(response);
    }

    @PutMapping("/{id}")
    public ApiResponse<CategoryResponse> update(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryRequest request) {

        CategoryResponse response = updateCategoryUseCase.execute(
                new CategoryUpdateCommand(
                        id,
                        request.name(),
                        request.icon()
                )
        );

        return ApiResponse.success(response);
    }

}
