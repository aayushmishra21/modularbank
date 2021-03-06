package com.modular.CurrentAccountService.model.entity;

import com.modular.CurrentAccountService.constant.Currency;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(BalanceId.class)
public class Balance {
    @Id
    private Long accountId;
    @Id
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column
    private BigDecimal balance;
}
