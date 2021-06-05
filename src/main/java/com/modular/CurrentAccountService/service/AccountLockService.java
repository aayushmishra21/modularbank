package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.constant.Currency;

public interface AccountLockService {
    public void lock(Long accountID, Currency currency);
    public void unLock(Long accountID, Currency currency);
}
