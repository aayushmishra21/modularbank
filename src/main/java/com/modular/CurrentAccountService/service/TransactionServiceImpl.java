package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.constant.TransactionDirection;
import com.modular.CurrentAccountService.converter.Converter;
import com.modular.CurrentAccountService.factory.MutexFactory;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.dto.TransactionDtoWithoutBalance;
import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.model.entity.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final BalanceService balanceService;
    private final CurrentAccountService currentAccountService;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        if(transactionDto == null){
            throw new RuntimeException("Null transaction DTO!");
        }
        Long accountId = transactionDto.getAccountId();
        if(accountId == null){
            throw new RuntimeException("Null account ID!");
        }
        if(!currentAccountService.existsById(accountId)){
            throw new RuntimeException("This account does not exist");
        }
        Currency currency = transactionDto.getCurrency();
        if(currency == null){
            throw new RuntimeException("Null currency!");
        }
        synchronized (MutexFactory.get(accountId, currency)) {
            Balance balance = balanceService.getBalance(accountId, currency);
            if (balance == null) {
                throw new RuntimeException("This account does not support " + currency + " currency.");
            }
            validateTransaction(balance, transactionDto);
            Transaction transaction = updateBalanceAndGetTransaction(balance, transactionDto);
            return saveBalanceAndTransaction(balance, transaction);
        }
    }

    private void validateTransaction(Balance balance, TransactionDto transactionDto) {
        if(transactionDto.getDirection() == null){
            throw new RuntimeException("Null direction!");
        }
        if(transactionDto.getAmount() == null){
            throw new RuntimeException("Null amount!");
        }
        if (transactionDto.getDirection().equals(TransactionDirection.IN))
            return;
        if (balance.getBalance().compareTo(transactionDto.getAmount()) < 0) {
            throw new RuntimeException("Insufficient balance");
        }
    }

    //todo should be transactional
    private TransactionDto saveBalanceAndTransaction(Balance balance, Transaction transaction) {
        //todo save to database
        return Converter.transactionToDto(balance, transaction);
    }


    private Transaction updateBalanceAndGetTransaction(Balance balance, TransactionDto transactionDto) {
        BigDecimal currentBalance = balance.getBalance();
        BigDecimal changeInBalance = transactionDto.getAmount();
        if (transactionDto.getDirection().equals(TransactionDirection.IN)) {
            balance.setBalance(currentBalance.add(changeInBalance));
        } else if (transactionDto.getDirection().equals(TransactionDirection.OUT)) {
            balance.setBalance(currentBalance.subtract(changeInBalance));
        }
        return Converter.transactionDtoToTransaction(transactionDto);
    }

    @Override
    public Set<TransactionDtoWithoutBalance> getTransactions(Long accountID) {
        //todo get transaction from db
        return new HashSet<>();
    }
}
