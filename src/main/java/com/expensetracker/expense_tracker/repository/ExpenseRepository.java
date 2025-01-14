package com.expensetracker.expense_tracker.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.expensetracker.expense_tracker.model.Expense;

public interface ExpenseRepository extends CrudRepository<Expense, Long> {
    List<Expense> findByCategory(String category);
}
