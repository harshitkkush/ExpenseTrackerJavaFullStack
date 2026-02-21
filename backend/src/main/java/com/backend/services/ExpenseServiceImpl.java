package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.Expense;
import com.backend.repositories.ExpenseRepo;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepo expenseRepo;

    @Override
    public Expense saveExpense(Expense expense) {
        return expenseRepo.save(expense);
    }

    @Override
    public List<Expense> getByUserId(Long userId) {
        return expenseRepo.getByUserId(userId);
    }

}