package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import org.springframework.stereotype.Service;

@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {
    @Override
    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        return null;
    }

    @Override
    public AccountDto getAccount(Long accountID) {
        return null;
    }
}
