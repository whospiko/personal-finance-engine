package com.app.expenseservice.presentation.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record CategoryExpenseResponse(
        UUID id, String name, String icon, LocalDateTime created, LocalDateTime updated
) {
}
