package com.expensetracker.expense_tracker.validator;

import com.expensetracker.expense_tracker.model.ExpenseEntity;
import com.expensetracker.expense_tracker.model.ExpenseCategory;

public class ExpenseValidator {
    public static void validateExpense(ExpenseEntity expense) {
        if (expense.getAmount() == null || expense.getAmount() <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero.");
        }

        if (expense.getDescription() == null || expense.getDescription().isBlank()) {
            throw new IllegalArgumentException("Description cannot be null or blank.");
        }

        if (expense.getCategory() == null || !isValidCategory(expense.getCategory().name())) {
            throw new IllegalArgumentException("Invalid category: " + expense.getCategory());
        }
    }

    private static boolean isValidCategory(String category) {
        for (ExpenseCategory validCategory : ExpenseCategory.values()) {
            if (validCategory.name().equalsIgnoreCase(category)) {
                return true;
            }
        }
        return false;
    }
}
