package com.modular.CurrentAccountService.model.dto;

import lombok.Data;

@Data
public class CreateTransactionDto {
    private Long accountId;
    private double amount;//todo check id double is ok
    private String currency;//todo can be enum
    private String transactionDirection;//todo can be enum
    private String description;
}
