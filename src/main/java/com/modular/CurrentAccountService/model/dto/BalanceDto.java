package com.modular.CurrentAccountService.model.dto;

import lombok.Data;

@Data
public class BalanceDto {
    private Double balance;
    private String currency;
}
