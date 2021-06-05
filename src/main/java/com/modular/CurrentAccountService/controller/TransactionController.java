package com.modular.CurrentAccountService.controller;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.dto.TransactionDto;
import com.modular.CurrentAccountService.model.dto.TransactionDtoWithoutBalance;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.model.entity.Transaction;
import com.modular.CurrentAccountService.service.TransactionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@AllArgsConstructor
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping(value = "/v1/create_transaction")
    public ResponseEntity<Object> createTransaction(@RequestBody CreateAccountDto createAccountDto) {
        TransactionDto transaction = transactionService.createTransaction(createAccountDto);
        return new ResponseEntity<>(transaction, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/get_transaction")
    public ResponseEntity<Object> getTransactions(@RequestParam(name = "account_id") Long accountID) {
        Set<TransactionDtoWithoutBalance> transactions = transactionService.getTransactions(accountID);
        return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
}
