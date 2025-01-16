package com.expensetracker.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.expensetracker.expense_tracker.model.ExpenseEntity;
import com.expensetracker.expense_tracker.repository.ExpenseRepository;
import com.expensetracker.expense_tracker.validator.ExpenseValidator;

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

    public Optional<ExpenseEntity> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public ExpenseEntity updateExpense(Long id, ExpenseEntity expenseDetails) {
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

    public void deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
        } else {
            throw new RuntimeException("Expense with id: " + id + " not found.");
        }
    }
}
