package br.com.mesttra.financial.controller;

import br.com.mesttra.financial.dto.ExpenseDto;
import br.com.mesttra.financial.dto.ExpenseDueDateDto;
import br.com.mesttra.financial.entity.Expense;
import br.com.mesttra.financial.service.ExpenseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) { this.expenseService = expenseService; }

    @PostMapping
    @ApiOperation(value = "Add expense",
            notes = "Adds a new expense in the financial Dept.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Expense added"),
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Expense addExpense(@RequestBody ExpenseDto expenseDto) {
        return expenseService.addExpense(expenseDto);
    }

    @GetMapping
    @ApiOperation(value = "List all expenses",
            notes = "Returns a list containing all expenses in the financial Dept.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public List<Expense> listExpenses() { return expenseService.listExpenses(); }

    @GetMapping(path = "/{id}")
    @ApiOperation(value = "Get an expense",
            notes = "Returns data about an expense in the financial Dept.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Optional<Expense> getExpense(@PathVariable Long id) { return expenseService.getExpense(id); }

    @PatchMapping(path = "/{id}")
    @ApiOperation(value = "Change an expense due date",
            notes = "Change an expense due date and returns data about the changed expense.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public Expense changeExpenseDueDate(@PathVariable Long id, @RequestBody ExpenseDueDateDto expenseDueDateDto) {

        return expenseService.changeExpenseDueDate(id, expenseDueDateDto.getDueDate());
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Delete an expense",
            notes = "Remove an expense and returns 'OK' in case of success.")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Error"),
    })
    public String removeExpense(@PathVariable Long id) { return expenseService.removeExpense(id); }
}
