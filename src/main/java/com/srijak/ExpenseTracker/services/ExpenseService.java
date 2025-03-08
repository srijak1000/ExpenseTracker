package com.srijak.ExpenseTracker.services;
import com.srijak.ExpenseTracker.dto.ExpenseDTO;
import com.srijak.ExpenseTracker.entity.Expense;

public interface ExpenseService {
    Expense postExpense(ExpenseDTO expenseDTO);
}
