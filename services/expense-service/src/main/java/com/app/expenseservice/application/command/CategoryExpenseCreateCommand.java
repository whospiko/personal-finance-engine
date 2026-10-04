package com.app.expenseservice.application.command;

public record CategoryExpenseCreateCommand(
        String name,
        String icon
) {
}
