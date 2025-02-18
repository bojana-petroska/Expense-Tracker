package com.expensetracker.expense_tracker.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.expensetracker.expense_tracker.model.ExpenseEntity;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseEntity, String> {
    List<ExpenseEntity> findByUserId(String userId);

    List<ExpenseEntity> findByCategory(String category);
}