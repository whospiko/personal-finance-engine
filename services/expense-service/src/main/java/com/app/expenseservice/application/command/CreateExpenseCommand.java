package com.app.expenseservice.application.command;

import java.util.UUID;

public record CreateExpenseCommand(
        Double amount,
        String note,
        UUID categoryId
) {
}
