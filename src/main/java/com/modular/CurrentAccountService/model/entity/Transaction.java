package com.modular.CurrentAccountService.model.entity;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.constant.TransactionDirection;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Transaction {
    private Long transactionId;
    private Long accountId;
    private BigDecimal amount;
    private Currency currency;
    private TransactionDirection direction;
    private String description;
}
