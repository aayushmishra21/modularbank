package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.converter.Converter;
import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.model.entity.Transaction;
import com.modular.CurrentAccountService.repository.AccountRepository;
import com.modular.CurrentAccountService.repository.BalanceRepository;
import com.modular.CurrentAccountService.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@Transactional
@AllArgsConstructor
public class SaveServiceImpl implements SaveService {
    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final TransactionRepository transactionRepository;
    private final BalanceService balanceService;

    public AccountDto saveAccount(CreateAccountDto createAccountDto) {
        Account account = Converter.createAccountDtoToAccount(createAccountDto);
        accountRepository.save(account);
        Set<Balance> balances = balanceService.initializeBalance(account, createAccountDto.getCurrency());
        return Converter.AccountToDto(account, balances);
    }

    public TransactionDto saveBalanceAndTransaction(Balance balance, Transaction transaction) {
        balance = balanceRepository.save(balance);
        transaction = transactionRepository.save(transaction);
        return Converter.transactionToDto(balance, transaction);
    }
}
