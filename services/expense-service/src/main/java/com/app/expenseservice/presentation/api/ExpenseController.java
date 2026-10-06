package com.app.expenseservice.presentation.api;

import com.app.common.dto.ApiResponse;
import com.app.expenseservice.application.command.CreateExpenseCommand;
import com.app.expenseservice.application.usecase.CreateExpenseUseCase;
import com.app.expenseservice.presentation.request.ExpenseRequest;
import com.app.expenseservice.presentation.response.ExpenseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final CreateExpenseUseCase createExpenseUseCase;

    @PostMapping
    public ApiResponse<ExpenseResponse> createExpense(
            @Valid @RequestBody ExpenseRequest expenseRequest) {

        ExpenseResponse response = createExpenseUseCase.execute(new CreateExpenseCommand(
                expenseRequest.amount(),
                expenseRequest.note(),
                expenseRequest.categoryId()
        ));

        return ApiResponse.success(response, "Created Expense");
    }

}
