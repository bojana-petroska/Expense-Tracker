package com.expensetracker.expense_tracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.expensetracker.expense_tracker.model.Expense;
import com.expensetracker.expense_tracker.repository.ExpenseRepository;
import com.expensetracker.expense_tracker.validator.ExpenseValidator;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public Expense createExpense(Expense expense) {
        ExpenseValidator.validateExpense(expense);
        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return (List<Expense>) expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense updateExpense(Long id, Expense expenseDetails) {
        ExpenseValidator.validateExpense(expenseDetails);

        Optional<Expense> optionalExpense = expenseRepository.findById(id);

        if (optionalExpense.isPresent()) {
            Expense existingExpense = optionalExpense.get();

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
