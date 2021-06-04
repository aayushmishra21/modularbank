package com.modular.CurrentAccountService.service;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.entity.Account;
import org.springframework.stereotype.Service;

import static com.modular.CurrentAccountService.converter.CurrentAccountDtoToEntityConverter.*;
@Service
public class CurrentAccountServiceImpl implements CurrentAccountService {
    @Override
    public Account createAccount(CreateAccountDto createAccountDto) {
        return convert(createAccountDto);
    }
}
