package com.app.budgetservice.core.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Objects;
import java.util.UUID;

public class BudgetSpending {
    private UUID id;
    private BudgetPeriod budgetPeriod;
    private Double currentSpent;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Budget budget;


    private BudgetSpending(
            UUID id,
            String yearMonth,
            Double currentSpent,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){
        if(currentSpent <= 0){
            throw new IllegalArgumentException("Current Spent must be greater than 0");
        }

        this.id = Objects.requireNonNull(id);
        this.budgetPeriod = BudgetPeriod.parse(yearMonth);
        this.currentSpent = currentSpent;
        this.createdAt = Objects.requireNonNull(createdAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }

    public static BudgetSpending create(
            String yearMonth,
            Double currentSpent
    ){
        return new BudgetSpending(
                UUID.randomUUID(),
                yearMonth,
                currentSpent,
                LocalDateTime.now(),
                LocalDateTime.now());
    }
}
