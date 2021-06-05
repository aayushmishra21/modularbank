package com.modular.CurrentAccountService.model.entity;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Account {
    private Long accountId;
    private String customerId;
    private String country;
}
