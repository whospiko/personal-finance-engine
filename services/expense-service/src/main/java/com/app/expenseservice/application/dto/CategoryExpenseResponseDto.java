package com.app.expenseservice.application.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record CategoryExpenseResponseDto(
        UUID id, String name, String icon, LocalDateTime created, LocalDateTime updated
) {
}
