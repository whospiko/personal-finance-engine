package com.app.expenseservice.presentation.response;

import java.util.UUID;

public record ExpenseResponse(
        UUID id, Double amount
) {
}