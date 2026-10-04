package com.app.expenseservice.presentation.api;

import com.app.common.dto.ApiResponse;
import com.app.expenseservice.application.command.CategoryExpenseCreateCommand;
import com.app.expenseservice.application.usecase.CreateCategoryExpenseUseCase;
import com.app.expenseservice.presentation.request.CategoryExpenseRequest;
import com.app.expenseservice.presentation.response.CategoryExpenseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class CategoryExpenseController {

    private final CreateCategoryExpenseUseCase createCategoryExpenseUseCase;

    @PostMapping()
    public ApiResponse<CategoryExpenseResponse> create(
            @Valid
            @RequestBody CategoryExpenseRequest request) {

        CategoryExpenseResponse response = createCategoryExpenseUseCase.execute(new CategoryExpenseCreateCommand(
                request.name(),
                request.icon()
        ));

        return ApiResponse.success(response);
    }

    @GetMapping("/{id}")
    public ApiResponse<CategoryExpenseResponse> updateUser(
            @PathVariable UUID id,
            @Valid @RequestBody CategoryExpenseRequest request) {
        return ApiResponse.success("Sda");
    }

}
