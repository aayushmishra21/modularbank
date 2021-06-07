package com.modular.CurrentAccountService.model.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AccountDto {
    private Long accountId;
    private String customerId;
    Set<BalanceDto> balance;
}
