package com.expensetracker.expenses;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Document(collection = "expenses")

public class ExpenseEntity {
    @Id
    private String id;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotNull(message = "Amount must be provided")
    @DecimalMin(value = "0.01", message = "Amount must be greater than zero")
    private Double amount;

    @NotNull(message = "Category must be provided")
    private ExpenseCategory category;

    private String userId;

    public ExpenseEntity() {
    }

    public ExpenseEntity(String description, Double amount, ExpenseCategory category, String userId) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }

    public String getUser() {
        return userId;
    }

    public void setUser(String userId) {
        this.userId = userId;
    }
}
