package com.app.expenseservice.infrastructure.adapter;

import com.app.expenseservice.core.entity.CategoryExpense;
import com.app.expenseservice.core.repository.CategoryExpenseRepository;
import com.app.expenseservice.infrastructure.mapper.CategoryExpensePersistenceMapper;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import com.app.expenseservice.infrastructure.persistence.SpringDataJpaCategoryExpenseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.logging.LoggingSystemFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CategoryExpenseRepositoryAdapter implements CategoryExpenseRepository {

    private final SpringDataJpaCategoryExpenseRepository categoryExpenseRepository;
    private final CategoryExpensePersistenceMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(CategoryExpenseRepositoryAdapter.class);

    @Override
    public CategoryExpense save(CategoryExpense categoryExpense) {
        logger.debug("Saving category expense {}", categoryExpense.toString());
        CategoryExpenseJpaEntity entity = mapper.toEntity(categoryExpense);
        logger.info("Entity {}", entity.toString());
        CategoryExpenseJpaEntity savedEntity = categoryExpenseRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<CategoryExpense> findById(UUID id) {
        return categoryExpenseRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<CategoryExpense> findAll() {
        return categoryExpenseRepository.findAll().stream().map(mapper::toDomain).toList();
    }
}