package com.modular.CurrentAccountService.model.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Currency;
import java.util.Set;

@Data
@Builder
public class Account {
    private Long id;
    private String customerId;
    private String country;
    private Set<Currency> currency;
}
