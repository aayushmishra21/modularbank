package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;

import java.util.Set;

public interface BalanceService {
    Set<Balance> initializeBalance(Account account, Set<Currency> currency);

    Balance getBalance(Long accountId, Currency currency);
}
