package com.app.expenseservice.infrastructure.persistence;

import com.app.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "category_expense")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CategoryExpenseJpaEntity extends BaseEntity {
    @Column(length = 100)
    private String name;

    @Column(length = 100)
    private String icon;
}
