package com.modular.CurrentAccountService.model.dto;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.constant.TransactionDirection;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateTransactionDto {
    private Long accountId;
    private BigDecimal amount;
    private Currency currency;
    private TransactionDirection transactionDirection;
    private String description;
}
