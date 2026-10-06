package com.app.budgetservice.infrastructure.persistence;

import com.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(
    name = "budget_spendings",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_budget_period", columnNames = {"budget_id", "month_year"})
    },
    indexes = {
        @Index(name = "idx_spending_period", columnList = "budget_id, month_year")
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetSpendingJpaEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "budget_id", nullable = false, foreignKey = @ForeignKey(name = "fk_spending_budget"))
    private BudgetJpaEntity budget;

    @Column(name = "month_year", nullable = false, length = 7)
    private String monthYear; // Saved directly as "2026-10" without any converter

    @Column(name = "current_spent", nullable = false)
    private Double currentSpent;
}
