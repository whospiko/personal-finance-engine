package com.app.budgetservice.presentation.api;

import com.app.budgetservice.infrastructure.client.ExpenseServiceClient;
import com.app.common.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/bugets")
@RequiredArgsConstructor
public class BudgetController {
    private final ExpenseServiceClient expenseServiceClient;

    public ApiResponse<Boolean> index(@PathVariable UUID categoryId) {
        Boolean expenseCategory = expenseServiceClient.checkCategoryExists(categoryId);

        return ApiResponse.success(expenseCategory);
    }
}
