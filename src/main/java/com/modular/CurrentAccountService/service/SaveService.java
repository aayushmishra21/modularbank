package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.model.entity.Transaction;

public interface SaveService {
    AccountDto saveAccount(CreateAccountDto createAccountDto);

    TransactionDto saveBalanceAndTransaction(Balance balance, Transaction transaction);
}
