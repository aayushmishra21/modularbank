package com.modular.CurrentAccountService.model.dto;

import lombok.Data;

import java.util.Currency;
import java.util.Set;

@Data
public class CreateAccountDto {
    private String customerId;
    private String country;
    private Set<Currency> currency;
}
