package com.app.expenseservice.presentation.api;

import com.app.common.dto.ApiResponse;
import com.app.expenseservice.application.command.CreateExpenseCommand;
import com.app.expenseservice.application.query.ExpenseResult;
import com.app.expenseservice.application.usecase.CreateExpenseUseCase;
import com.app.expenseservice.application.usecase.GetExpenseUseCase;
import com.app.expenseservice.core.entity.Expense;
import com.app.expenseservice.presentation.request.ExpenseRequest;
import com.app.expenseservice.presentation.response.ExpenseResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/expenses")
@RequiredArgsConstructor
public class ExpenseController {

    private final CreateExpenseUseCase createExpenseUseCase;
    private final GetExpenseUseCase getExpenseUseCase;


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

    @GetMapping("/{id}")
    public ApiResponse<Expense> getExpense(@PathVariable UUID id) {

        Expense response = getExpenseUseCase.execute(new ExpenseResult(id));

        return ApiResponse.success(response, "Get Expense");
    }

}
