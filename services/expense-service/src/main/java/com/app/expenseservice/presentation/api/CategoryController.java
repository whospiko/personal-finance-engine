package com.app.expenseservice.presentation.api;

import com.app.common.dto.ApiResponse;
import com.app.expenseservice.application.command.CategoryCreateCommand;
import com.app.expenseservice.application.usecase.CreateCategoryUseCase;
import com.app.expenseservice.presentation.request.CategoryRequest;
import com.app.expenseservice.presentation.response.CategoryResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class CategoryController {

    private final CreateCategoryUseCase createCategoryExpenseUseCase;

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

    @GetMapping("/{id}")
    public ApiResponse<CategoryResponse> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryRequest request) {
        return ApiResponse.success("Sda");
    }

}
