package com.modular.CurrentAccountService.model.dto;

import lombok.Data;

import java.util.Set;

@Data
public class AccountDto {
    private Long accountId;
    private String customerId;
    Set<BalanceDto> balance;
}
