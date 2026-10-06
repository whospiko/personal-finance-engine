package com.app.budgetservice.core.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Budget {

    private UUID id;
    private UUID categoryId;
    private Double monthlyLimit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<BudgetSpending> budgetSpendingList;

    private Budget(
            UUID id,
            UUID categoryId,
            Double monthlyLimit,
            LocalDateTime createdAt
    ){
        if(monthlyLimit <= 0){
            throw new IllegalArgumentException("Monthly Limit must be greater than 0");
        }

        this.id = Objects.requireNonNull(id);
        this.categoryId = Objects.requireNonNull(categoryId);
        this.monthlyLimit = monthlyLimit;
        this.createdAt = createdAt;
    }

    public static Budget create(
            UUID categoryId,
            Double monthlyLimit
    ){
        return new Budget(
                UUID.randomUUID(),
                categoryId,
                monthlyLimit,
                LocalDateTime.now()
        );
    }

    public static Budget restore(
            UUID id,
            UUID categoryId,
            Double monthlyLimit,
            LocalDateTime createdAt,
            List<BudgetSpending> budgetSpendingList
    ){
        Budget budget =  new Budget(
                id,
                categoryId,
                monthlyLimit,
                createdAt
        );

       budget.budgetSpendingList = budgetSpendingList;

        return budget;
    }

    public Budget add(BudgetSpending spending){

        if(this.budgetSpendingList == null){
            budgetSpendingList = new ArrayList<>();
        }

        this.budgetSpendingList.add(spending);

        return this;
    }





}
