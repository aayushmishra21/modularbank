package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.constant.Currency;
import org.springframework.stereotype.Service;

@Service
public class AccountLockServiceImpl implements AccountLockService{
    @Override
    public void lock(Long accountID, Currency currency) {

    }

    @Override
    public void unLock(Long accountID, Currency currency) {

    }
}
