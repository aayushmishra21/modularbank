package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.entity.Account;

public interface CurrentAccountService {
    Account createAccount(CreateAccountDto createAccountDto);
}
