package com.expensetracker.expense_tracker.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.expensetracker.expense_tracker.model.ExpenseEntity;

public interface ExpenseRepository extends CrudRepository<ExpenseEntity, Long> {
    List<ExpenseEntity> findByCategory(String category);
}
