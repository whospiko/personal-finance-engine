package com.app.budgetservice.infrastructure.persistence;

import com.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(
    name = "budgets",
    uniqueConstraints = {
        @UniqueConstraint(name = "uq_category_budget", columnNames = {"category_id"})
    }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetJpaEntity extends BaseEntity {
    @Column(name = "category_id", nullable = false)
    private UUID categoryId;

    @Column(name = "monthly_limit", nullable = false)
    private Double monthlyLimit;

    @OneToMany(
        mappedBy = "budget",
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        fetch = FetchType.LAZY
    )
    @Builder.Default
    private List<BudgetSpendingJpaEntity> budgetSpendingList = new ArrayList<>();
}
