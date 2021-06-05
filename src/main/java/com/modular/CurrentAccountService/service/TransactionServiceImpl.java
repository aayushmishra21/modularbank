package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.dto.TransactionDtoWithoutBalance;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class TransactionServiceImpl implements TransactionService{
    @Override
    public TransactionDto createTransaction(CreateAccountDto createAccountDto) {
        return null;
    }

    @Override
    public Set<TransactionDtoWithoutBalance> getTransactions(Long accountID) {
        return null;
    }
}
