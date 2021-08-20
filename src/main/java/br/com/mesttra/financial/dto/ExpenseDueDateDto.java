package br.com.mesttra.financial.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ExpenseDueDateDto {
    private LocalDate dueDate;
}
