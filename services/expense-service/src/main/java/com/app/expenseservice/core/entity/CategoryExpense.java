package com.app.expenseservice.core.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
public class CategoryExpense {
    private UUID id;
    private String name;
    private String icon;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CategoryExpense create(String name, String icon){
        CategoryExpense categoryExpense = new CategoryExpense();

        categoryExpense.id = UUID.randomUUID();
        categoryExpense.name = Objects.requireNonNull(name, "Name cannot be null");
        categoryExpense.icon = Objects.requireNonNull(icon, "Icon cannot be null");

        return categoryExpense;
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
