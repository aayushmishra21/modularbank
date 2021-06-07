package com.modular.CurrentAccountService.model.dto;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.constant.TransactionDirection;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionDto {
    private Long accountId;
    private Long transactionId;
    private BigDecimal amount;
    private Currency currency;
    private TransactionDirection direction;
    private String description;
    private BigDecimal balanceAfterTransaction;
}
