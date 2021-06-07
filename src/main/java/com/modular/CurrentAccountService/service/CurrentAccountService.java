package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;

public interface CurrentAccountService {
    AccountDto createAccount(CreateAccountDto createAccountDto);

    AccountDto getAccount(Long accountID);

    boolean existsById(Long accountId);
}
