package com.app.expenseservice.infrastructure.persistence;

import com.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "category_expense")
@Getter
@Setter
@ToString(exclude = "expenses") // Prevent StackOverflow
@NoArgsConstructor
@AllArgsConstructor
public class CategoryExpenseJpaEntity extends BaseEntity {
    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String icon;

    // Fix: Add mappedBy to use foreign key instead of join table
    @OneToMany(mappedBy = "categoryExpense", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExpenseJpaEntity> expenses;
}