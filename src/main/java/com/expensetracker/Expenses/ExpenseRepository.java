package com.expensetracker.expenses;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<ExpenseEntity, String> {
    List<ExpenseEntity> findByUserId(String userId);

    List<ExpenseEntity> findByCategory(String category);
}