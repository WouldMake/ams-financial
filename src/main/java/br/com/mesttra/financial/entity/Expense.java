package br.com.mesttra.financial.entity;

import br.com.mesttra.financial.enums.ExpenseType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(
            value = "Expense id",
            name = "id",
            dataType = "Long",
            example = "1")
    private Long id;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(
            value = "Expense type",
            name = "expenseType",
            dataType = "String",
            example = "SALARY")
    private ExpenseType expenseType;

    @ApiModelProperty(
            value = "Expense amount",
            name = "amount",
            dataType = "Double",
            example = "100000.00")
    private Double amount;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @ApiModelProperty(
            value = "Expense due date",
            name = "dueDate",
            dataType = "Date",
            example = "2021-09-10")
    private LocalDate dueDate;

}
