package com.modular.CurrentAccountService.model.dto;

import lombok.Data;

@Data
public class TransactionDtoWithoutBalance {
    private Long accountId;
    private Long transactionId;
    private Double amount;
    private String currency;
    private String direction;
    private String description;
    private Double balanceAfterTransaction;
}
