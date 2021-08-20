package br.com.mesttra.financial.service;

import br.com.mesttra.financial.enums.ExpenseType;
import br.com.mesttra.financial.repository.ExpenseRepository;
import br.com.mesttra.financial.dto.ExpenseDto;
import br.com.mesttra.financial.entity.Expense;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ExpenseService {

    ExpenseRepository expenseRepository;

    public Expense addExpense(ExpenseDto expenseDto) {

        Expense expense = new Expense();
        expense.setExpenseType(ExpenseType.valueOf(expenseDto.getType()));
        expense.setAmount(expenseDto.getAmount());
        expense.setDueDate(LocalDate.now());

        return expenseRepository.save(expense);
    }

    public List<Expense> listExpenses() { return expenseRepository.findAll(); }

    public Optional<Expense> getExpense(Long id) { return expenseRepository.findById(id); }

    public Expense changeExpenseDueDate(Long id, LocalDate dueDate) {

        Expense expense = expenseRepository.getById(id);
        expense.setDueDate(dueDate);

        return expenseRepository.save(expense);
    }

    public String removeExpense(Long id) {

        expenseRepository.deleteById(id);

        return "OK";
    }
}
