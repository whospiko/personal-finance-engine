package com.app.expenseservice.core.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Expense {
    private final UUID id;
    private Double amount;
    private String note;
    private LocalDateTime transactionDate;
    private final Category category; // Aggregate Category info inside Expense
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private Expense(
            UUID id,
            Double amount,
            String note,
            LocalDateTime transactionDate,
            Category category,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        this.id = Objects.requireNonNull(id);
        this.amount = amount;
        this.note = Objects.requireNonNull(note);
        this.transactionDate = Objects.requireNonNull(transactionDate);
        this.category = Objects.requireNonNull(category, "Category cannot be null");
        this.createdAt = Objects.requireNonNull(createdAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }

    public static Expense create(Double amount, String note, Category category) {
        LocalDateTime now = LocalDateTime.now();
        return new Expense(
                UUID.randomUUID(),
                amount,
                note,
                now,
                category,
                now,
                now
        );
    }

    public static Expense restore(
            UUID id,
            Double amount,
            String note,
            LocalDateTime transactionDate,
            Category category,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new Expense(id, amount, note, transactionDate, category, createdAt, updatedAt);
    }

    public void updateDetails(Double newAmount, String newNote, LocalDateTime newDate) {
        if (newAmount == null || newAmount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        this.amount = newAmount;
        this.note = Objects.requireNonNull(newNote, "Note cannot be null");
        this.transactionDate = Objects.requireNonNull(newDate, "Transaction date cannot be null");
    }
}