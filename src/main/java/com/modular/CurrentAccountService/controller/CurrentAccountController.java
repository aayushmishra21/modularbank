package com.modular.CurrentAccountService.controller;

import com.modular.CurrentAccountService.model.dto.AccountDto;
import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.service.CurrentAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CurrentAccountController {

    private final CurrentAccountService currentAccountService;

    @PostMapping(value = "/v1/create_account")
    public ResponseEntity<AccountDto> createAccount(@RequestBody CreateAccountDto createAccountDto) {
        AccountDto account = currentAccountService.createAccount(createAccountDto);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping(value = "/v1/get_account")
    public ResponseEntity<AccountDto> getAccount(@RequestParam(name = "account_id") Long accountId) {
        AccountDto account = currentAccountService.getAccount(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
