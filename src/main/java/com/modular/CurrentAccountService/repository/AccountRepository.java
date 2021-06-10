package com.modular.CurrentAccountService.repository;

import com.modular.CurrentAccountService.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    boolean existsByCustomerId(String customerId);
}
