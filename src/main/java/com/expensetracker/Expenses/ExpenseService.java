package com.expensetracker.Expenses;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public ExpenseEntity createExpense(ExpenseEntity expense) {
        ExpenseValidator expenseValidator = new ExpenseValidator();
        expenseValidator.validateExpense(expense);
        return expenseRepository.save(expense);
    }

    public List<ExpenseEntity> getAllExpenses() {
        return (List<ExpenseEntity>) expenseRepository.findAll();
    }

    public Optional<ExpenseEntity> getExpenseById(String id) {
        return expenseRepository.findById(id);
    }

    public ExpenseEntity updateExpense(String id, ExpenseEntity expenseDetails) {
        ExpenseValidator expenseValidator = new ExpenseValidator();
        expenseValidator.validateExpense(expenseDetails);

        Optional<ExpenseEntity> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isPresent()) {
            ExpenseEntity existingExpense = optionalExpense.get();

            existingExpense.setDescription(expenseDetails.getDescription());
            existingExpense.setAmount(expenseDetails.getAmount());
            existingExpense.setCategory(expenseDetails.getCategory());

            return expenseRepository.save(existingExpense);
        } else {
            throw new RuntimeException("Expense with id: " + id + " not found.");
        }
    }

    public void deleteExpense(String id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Expense with id: " + id + " not found.");
        }
    }
}
