package com.modular.CurrentAccountService.model.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Balance {
    private Long accountId;
    private String currency;
    private Double balance;
}
