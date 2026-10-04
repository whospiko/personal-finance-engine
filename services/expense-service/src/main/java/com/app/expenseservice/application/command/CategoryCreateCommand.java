package com.app.expenseservice.application.command;

public record CategoryCreateCommand(
        String name,
        String icon
) {
}
