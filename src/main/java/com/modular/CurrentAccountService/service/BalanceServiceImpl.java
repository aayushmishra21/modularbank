package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.model.entity.BalanceId;
import com.modular.CurrentAccountService.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;
    @Override
    public Set<Balance> initializeBalance(Account account, Set<Currency> currency) {
        Set<Balance> balances = new HashSet<>();
        currency.forEach(c -> balances.add(Balance.builder()
                .balance(new BigDecimal(0))
                .currency(c)
                .accountId(account.getAccountId()).build()));
        balanceRepository.saveAll(balances);
        return balances;
    }



    public Balance getBalance(Long accountId, Currency currency) {
        return balanceRepository.getById(new BalanceId(accountId, currency));
    }
}
