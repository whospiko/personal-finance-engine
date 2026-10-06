package com.app.expenseservice.infrastructure.adapter;

import com.app.expenseservice.core.entity.Category;
import com.app.expenseservice.core.repository.CategoryRepository;
import com.app.expenseservice.infrastructure.mapper.CategoryPersistenceMapper;
import com.app.expenseservice.infrastructure.persistence.CategoryExpenseJpaEntity;
import com.app.expenseservice.infrastructure.persistence.SpringDataJpaCategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CategoryExpenseRepositoryAdapter implements CategoryRepository {

    private final SpringDataJpaCategoryRepository categoryExpenseRepository;
    private final CategoryPersistenceMapper mapper;
    private final Logger logger = LoggerFactory.getLogger(CategoryExpenseRepositoryAdapter.class);

    @Override
    public Category save(Category category) {
        logger.debug("Saving category expense {}", category.toString());
        CategoryExpenseJpaEntity entity = mapper.toEntity(category);
        logger.info("Entity {}", entity.toString());
        CategoryExpenseJpaEntity savedEntity = categoryExpenseRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return categoryExpenseRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Category> findAll() {
        return categoryExpenseRepository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Boolean existsById(UUID id) {
        return categoryExpenseRepository.existsById(id);
    }
}