package com.modular.CurrentAccountService.model.entity;

import com.modular.CurrentAccountService.constant.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Balance {
    private Long accountId;
    private Currency currency;
    private BigDecimal balance;
}
