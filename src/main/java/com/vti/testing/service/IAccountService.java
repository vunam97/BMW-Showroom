package com.vti.testing.service;

import com.vti.testing.entity.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IAccountService {
    Page<Account> getAll(Pageable pageable, String search);

    Account createAccount(Account account);

    Optional<Account> findByUsername(String username);

    Optional<Account> getAccountById(Integer id);

    Optional<Account> updateAccount(Integer id, Account updatedAccount);

    boolean deleteAccount(Integer id);
}
