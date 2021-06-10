package com.modular.CurrentAccountService.model.entity;

import com.modular.CurrentAccountService.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceId implements Serializable {
    private Long accountId;
    private Currency currency;
}
