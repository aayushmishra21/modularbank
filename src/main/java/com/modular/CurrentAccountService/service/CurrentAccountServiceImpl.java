package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.converter.Converter;
import com.modular.CurrentAccountService.factory.MutexFactory;
import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.repository.AccountRepository;
import com.modular.CurrentAccountService.repository.BalanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;

@Service
@AllArgsConstructor
public class CurrentAccountServiceImpl implements CurrentAccountService {

    private final BalanceService balanceService;
    private final AccountRepository accountRepository;
    private final BalanceRepository balanceRepository;
    private final SaveService saveService;

    @Override
    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        synchronized (MutexFactory.get(createAccountDto.getCustomerId())) {
            validateNewAccount(createAccountDto);
            return saveService.saveAccount(createAccountDto);
        }
    }




    private void validateNewAccount(CreateAccountDto createAccountDto) {
        if (createAccountDto == null) {
            throw new RuntimeException("Invalid request!");
        }
        if (!StringUtils.hasText(createAccountDto.getCustomerId())) {
            throw new RuntimeException("Customer Id is required!");
        }
        createAccountDto.setCustomerId(createAccountDto.getCustomerId().trim().toLowerCase());
        boolean accountExistsWithCustomerId = accountRepository.existsByCustomerId(createAccountDto.getCustomerId());
        if (accountExistsWithCustomerId) {
            throw new RuntimeException("Customer Id already in use!");
        }
        if (!StringUtils.hasText(createAccountDto.getCountry())) {
            throw new RuntimeException("Country is required!");
        }
        createAccountDto.setCountry(createAccountDto.getCountry().trim().toLowerCase());
        if (CollectionUtils.isEmpty(createAccountDto.getCurrency())) {
            throw new RuntimeException("Currency is required!");
        }
    }

    @Override
    public AccountDto getAccount(Long accountID) {
        Account account = accountRepository.getById(accountID);
        if (account.getAccountId() == null) {
            throw new RuntimeException("Account id : " + accountID + " does not exist!");
        }
        HashSet<Balance> balanceSet = new HashSet<>(balanceRepository.getByAccountId(accountID));
        return Converter.AccountToDto(account, balanceSet);
    }
}
