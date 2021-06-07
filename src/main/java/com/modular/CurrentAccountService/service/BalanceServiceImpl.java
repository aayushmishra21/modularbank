package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
public class BalanceServiceImpl implements BalanceService {
    @Override
    public Set<Balance> initializeBalance(Account account, Set<Currency> currency) {
        Set<Balance> balances = new HashSet<>();
        currency.forEach(c -> balances.add(Balance.builder()
                .balance(new BigDecimal(0))
                .currency(c)
                .accountId(account.getAccountId()).build()));
        //todo save balance
        return balances;
    }



    public Balance getBalance(Long accountId, Currency currency) {
        //todo get Balance from DB
        return null;

    }
}
