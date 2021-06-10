package com.modular.CurrentAccountService.repository;

import com.modular.CurrentAccountService.model.entity.Balance;
import com.modular.CurrentAccountService.model.entity.BalanceId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, BalanceId> {
    List<Balance> getByAccountId(Long accountID);
}
