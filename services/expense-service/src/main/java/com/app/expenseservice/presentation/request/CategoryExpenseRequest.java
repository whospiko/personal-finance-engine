package com.app.expenseservice.presentation.request;

import jakarta.validation.constraints.NotBlank;

public record CategoryExpenseRequest(
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Icon is required") String icon
) {
}
