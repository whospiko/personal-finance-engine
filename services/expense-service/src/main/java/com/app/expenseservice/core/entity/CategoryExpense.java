package com.app.expenseservice.core.entity;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
public class CategoryExpense {
    private final UUID id;
    private String name;
    private String icon;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private CategoryExpense(
            UUID id,
            String name,
            String icon,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ){
        this.id = Objects.requireNonNull(id);
        this.name = Objects.requireNonNull(name);
        this.icon = Objects.requireNonNull(icon);
        this.createdAt = Objects.requireNonNull(createdAt);
        this.updatedAt = Objects.requireNonNull(updatedAt);
    }

    public static CategoryExpense create(String name, String icon){
        return new CategoryExpense(
                UUID.randomUUID(),
                name,
                icon,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public static CategoryExpense restore(
            UUID id,
            String name,
            String icon,
            LocalDateTime createdAt,
            LocalDateTime updatedAt
    ) {
        return new CategoryExpense(
                id,
                name,
                icon,
                createdAt,
                updatedAt
        );
    }

    public void changeName(String newName){
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException("New name cannot be blank");
        }

        this.name = newName;
    }

    public void changeIcon(String newIcon){
        if (newIcon == null || newIcon.isBlank()) {
            throw new IllegalArgumentException("New name cannot be blank");
        }

        this.icon = newIcon;
    }

}
