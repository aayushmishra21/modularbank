package com.modular.CurrentAccountService.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private Long transactionId;
    private Long accountId;
    private Double amount;
    private String currency;
    private String direction;
    private String description;
}
