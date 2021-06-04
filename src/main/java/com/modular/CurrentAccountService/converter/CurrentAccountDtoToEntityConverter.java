package com.modular.CurrentAccountService.converter;

import com.modular.CurrentAccountService.model.dto.CreateAccountDto;
import com.modular.CurrentAccountService.model.entity.Account;

public class CurrentAccountDtoToEntityConverter {
    public static Account convert(CreateAccountDto createAccountDto) {
        if (createAccountDto == null) {
            return null;
        }
        return Account.builder().currency(createAccountDto.getCurrency())
                .customerId(createAccountDto.getCustomerId())
                .country(createAccountDto.getCountry()).build();
    }
}
