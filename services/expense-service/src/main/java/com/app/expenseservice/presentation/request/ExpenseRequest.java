package com.app.expenseservice.presentation.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ExpenseRequest(
        @DecimalMin(value = "0", message = "Amount must be grater than 0")
        Double amount,
        @NotBlank(message = "Note is required") String note,
        UUID categoryId
        ) {
}
