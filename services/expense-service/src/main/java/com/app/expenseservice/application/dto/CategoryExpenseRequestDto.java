package com.app.expenseservice.application.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoryExpenseRequestDto(
        @NotBlank(message = "Name is required") String name,
        @NotBlank(message = "Icon is required") String icon
) {
}
