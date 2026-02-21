package com.backend.services;

import com.backend.entities.Expense;

import java.util.List;

public interface ExpenseService {
    public Expense saveExpense(Expense expense);

    public List<Expense> getByUserId(Long userId);

}