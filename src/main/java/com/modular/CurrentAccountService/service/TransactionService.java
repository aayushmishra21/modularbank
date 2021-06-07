package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.dto.TransactionDtoWithoutBalance;

import java.util.Set;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);

    Set<TransactionDtoWithoutBalance> getTransactions(Long accountID);
}
