package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.converter.Converter;
import com.modular.CurrentAccountService.factory.MutexFactory;
import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class CurrentAccountServiceImpl implements CurrentAccountService {

    private final BalanceService balanceService;

    @Override
    public AccountDto createAccount(CreateAccountDto createAccountDto) {
        synchronized (MutexFactory.get(createAccountDto.getCustomerId())) {
            validateNewAccount(createAccountDto);
            return saveAccount(createAccountDto);
        }
    }

    //todo transactional
    private AccountDto saveAccount(CreateAccountDto createAccountDto) {
        Account account = Converter.createAccountDtoToAccount(createAccountDto);
        //todo save account
        Set<Balance> balances = balanceService.initializeBalance(account, createAccountDto.getCurrency());
        return Converter.AccountToDto(account, balances);
    }

    private void validateNewAccount(CreateAccountDto createAccountDto) {
        if (createAccountDto == null) {
            throw new RuntimeException("Invalid request!");
        }
        if (!StringUtils.hasText(createAccountDto.getCustomerId())) {
            throw new RuntimeException("Customer Id is required!");
        }
        createAccountDto.setCustomerId(createAccountDto.getCustomerId().trim().toLowerCase());
        boolean accountExistsWithCustomerId = false;//todo
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
        //todo getAccountById
        Account account = Account.builder().build();
        if (account == null) {
            throw new RuntimeException("Account id : " + accountID + " does not exist!");
        }
        //todo get balances
        Set<Balance> balanceSet = new HashSet();
        return Converter.AccountToDto(account, balanceSet);
    }

    @Override
    public boolean existsById(Long accountId) {
        //todo get from db
        return true;
    }
}
