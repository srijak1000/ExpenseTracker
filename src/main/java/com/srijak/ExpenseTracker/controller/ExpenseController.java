package com.srijak.ExpenseTracker.controller;

import com.srijak.ExpenseTracker.dto.ExpenseDTO;
import com.srijak.ExpenseTracker.entity.Expense;
import com.srijak.ExpenseTracker.services.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<?> postExpense(@RequestBody ExpenseDTO dto) {
        Expense createdExpense = expenseService.postExpense(dto);
        if(createdExpense != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
