package com.srijak.ExpenseTracker.services;
import com.srijak.ExpenseTracker.dto.ExpenseDTO;
import com.srijak.ExpenseTracker.entity.Expense;
import com.srijak.ExpenseTracker.repository.ExpenseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    private Expense saveOrUpdateExpense(Expense expense, ExpenseDTO expenseDTO){
        expense.setTitle(expenseDTO.getTitle());
        expense.setDate(expenseDTO.getDate());
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription((expenseDTO.getDescription()));

        return expenseRepository.save(expense);
    }

    public Expense postExpense(ExpenseDTO expenseDTO){
        return saveOrUpdateExpense(new Expense(), expenseDTO);
    }

    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Expense::getDate)
                        .reversed())
                .collect(Collectors
                        .toList());
    }

    public Expense getExpenseById(Long id){
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()){
            return optionalExpense.get();
        } else {
            throw new EntityNotFoundException("No expense found with id:" + id);
        }
    }
}