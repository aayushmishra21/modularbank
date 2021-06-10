package com.modular.CurrentAccountService.model.entity;

import com.modular.CurrentAccountService.constant.Currency;
import com.modular.CurrentAccountService.constant.TransactionDirection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    @Column
    private Long accountId;
    @Column
    private BigDecimal amount;
    @Column
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Column
    @Enumerated(EnumType.STRING)
    private TransactionDirection direction;
    @Column
    private String description;
}
