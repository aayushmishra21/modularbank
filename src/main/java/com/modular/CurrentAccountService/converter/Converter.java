package com.modular.CurrentAccountService.converter;

import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.BalanceDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.model.entity.Transaction;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Converter {
    public static AccountDto AccountToDto(Account account, Collection<Balance> balanceCollection) {
        Set<BalanceDto> balances = new HashSet<>();
        balanceCollection.forEach(b -> balances.add(balanceToDto(b)));
        return AccountDto.builder()
                .accountId(account.getAccountId())
                .balance(balances)
                .customerId(account.getCustomerId())
                .build();
    }

    public static BalanceDto balanceToDto(Balance balance) {
        return BalanceDto.builder().balance(balance.getBalance()).currency(balance.getCurrency()).build();
    }

    public static Account createAccountDtoToAccount(CreateAccountDto createAccountDto) {
        return Account.builder().country(createAccountDto.getCountry()).customerId(createAccountDto.getCustomerId()).build();
    }

    public static Transaction transactionDtoToTransaction(TransactionDto transactionDto) {
        return Transaction.builder()
                .direction(transactionDto.getDirection())
                .accountId(transactionDto.getAccountId())
                .amount(transactionDto.getAmount())
                .currency(transactionDto.getCurrency())
                .description(transactionDto.getDescription()).build();
    }

    public static TransactionDto transactionToDto(Balance balance, Transaction transaction) {
        return TransactionDto.builder()
                .transactionId(transaction.getTransactionId())
                .balanceAfterTransaction(balance.getBalance())
                .currency(transaction.getCurrency())
                .direction(transaction.getDirection())
                .accountId(transaction.getAccountId())
                .amount(transaction.getAmount())
                .description(transaction.getDescription())
                .build();
    }
}
