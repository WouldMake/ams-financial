package br.com.mesttra.financial.dto;

import lombok.Data;

@Data
public class ExpenseDto {
    private String type;
    private Double amount;
}
