package com.modular.CurrentAccountService.controller;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.entity.Account;
import com.modular.CurrentAccountService.service.CurrentAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "")
@AllArgsConstructor
public class CurrentAccountController {
    private final CurrentAccountService currentAccountService;

    @PostMapping(value = "/v1/test")
    public ResponseEntity<String> testService() {
        return new ResponseEntity<>("Service running!", HttpStatus.OK);
    }

    @PostMapping(value = "/v1/create_account")
    public ResponseEntity<Object> createAccount(@RequestBody CreateAccountDto createAccountDto) {
        Account account = currentAccountService.createAccount(createAccountDto);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
