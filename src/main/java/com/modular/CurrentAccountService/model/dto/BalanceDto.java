package com.modular.CurrentAccountService.model.dto;

import com.modular.CurrentAccountService.constant.Currency;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class BalanceDto {
    private BigDecimal balance;
    private Currency currency;
}
