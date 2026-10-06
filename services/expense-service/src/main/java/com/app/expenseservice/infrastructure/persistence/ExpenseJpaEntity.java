package com.app.expenseservice.infrastructure.persistence;

import com.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "expenses")
@Getter
@Setter
public class ExpenseJpaEntity extends BaseEntity {

    @Column(name = "amount")
    private Double amount;

    @Column(name = "note")
    private String note;

    @Column(name = "transection_date")
    private LocalDateTime transectionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_expense_id", nullable = false)
    private CategoryExpenseJpaEntity categoryExpense;

}