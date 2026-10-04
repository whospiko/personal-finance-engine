package com.app.expenseservice.application.command;

import java.util.UUID;

public record CategoryUpdateCommand(
        UUID id,
        String name,
        String icon
) {
}
