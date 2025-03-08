package com.srijak.ExpenseTracker.services;
import com.srijak.ExpenseTracker.dto.ExpenseDTO;
import com.srijak.ExpenseTracker.entity.Expense;
import java.util.List;

public interface ExpenseService {

    Expense postExpense(ExpenseDTO expenseDTO);

    List<Expense> getAllExpenses();
}