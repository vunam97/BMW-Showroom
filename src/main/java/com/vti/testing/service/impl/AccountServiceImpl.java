package com.vti.testing.service.impl;

import com.vti.testing.entity.Account;
import com.vti.testing.repository.AccountRepository;
import com.vti.testing.service.IAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private ModelMapper modelMapper;



//    @Override
//    public Page<Account> getAll(Pageable pageable) {
//        return accountRepository.findAll(pageable);
//    }

    @Override
    public Page<Account> getAll(Pageable pageable, String search) {
        if (search != null && !search.isEmpty()) {
            return accountRepository.findByUsernameContainingIgnoreCase(search, pageable);
        } else {
            return accountRepository.findAll(pageable);
        }
    }

    @Override
    public Account createAccount(Account account) {
//        account.setRole(Role.USER);
        account.setCreateAt(LocalDateTime.now());
        return accountRepository.save(account);
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        return accountRepository.findByUsername(username);
    }

    @Override
    public Optional<Account> getAccountById(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public Optional<Account> updateAccount(Integer id, Account updatedAccount) {

        return accountRepository.findById(id).map(existingAccount -> {
            existingAccount.setUsername(updatedAccount.getUsername() != null ? updatedAccount.getUsername() : existingAccount.getUsername());
            existingAccount.setFirstName(updatedAccount.getFirstName() != null ? updatedAccount.getFirstName() : existingAccount.getFirstName());
            existingAccount.setLastName(updatedAccount.getLastName() != null ? updatedAccount.getLastName() : existingAccount.getLastName());
            existingAccount.setRole(updatedAccount.getRole() != null ? updatedAccount.getRole() : existingAccount.getRole());
//            existingAccount.setRole(updatedAccount.getRole() != null ? updatedAccount.getRole() : Role.USER);

            return accountRepository.save(existingAccount);
        });
    }

    @Override
    public boolean deleteAccount(Integer id) {
        Optional<Account> existingAccount = accountRepository.findById(id);

        if (existingAccount.isPresent()) {
            accountRepository.deleteById(id);
            return true; // Xóa thành công
        } else {
            return false; // Không có dữ liệu để xóa
        }
    }
}