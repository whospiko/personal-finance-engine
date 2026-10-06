package com.app.expenseservice.infrastructure.mapper;

import com.app.expenseservice.core.entity.Category;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CategoryPersistenceMapper {

    public CategoryExpenseJpaEntity toEntity(Category domain) {
        CategoryExpenseJpaEntity categoryExpenseJpaEntity = new CategoryExpenseJpaEntity();

        categoryExpenseJpaEntity.setId(domain.getId());
        categoryExpenseJpaEntity.setName(domain.getName());
        categoryExpenseJpaEntity.setIcon(domain.getIcon());
        categoryExpenseJpaEntity.setCreatedAt(domain.getCreatedAt());
        categoryExpenseJpaEntity.setUpdatedAt(domain.getUpdatedAt());

        return categoryExpenseJpaEntity;
    }

    public Category toDomain(CategoryExpenseJpaEntity entity) {
        LocalDateTime createdAt = entity.getCreatedAt() != null
                ? entity.getCreatedAt()
                : LocalDateTime.now();

        LocalDateTime updatedAt = entity.getUpdatedAt() != null
                ? entity.getUpdatedAt()
                : createdAt;

        return Category.restore(
                entity.getId(),
                entity.getName(),
                entity.getIcon(),
                createdAt,
                updatedAt
        );
    }
}
