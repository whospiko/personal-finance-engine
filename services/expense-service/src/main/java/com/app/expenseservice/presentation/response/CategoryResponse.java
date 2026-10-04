package com.app.expenseservice.presentation.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record CategoryResponse(
        UUID id, String name, String icon, LocalDateTime created, LocalDateTime updated
) {
}
