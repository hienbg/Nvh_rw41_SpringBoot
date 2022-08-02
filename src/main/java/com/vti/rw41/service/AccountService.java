package com.vti.rw41.service;

import com.vti.rw41.dto.AccountRequest;
import com.vti.rw41.entity.AccountEntity;
import com.vti.rw41.repository.AccountRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    public AccountEntity register(AccountRequest accountRequest) {

        AccountEntity account = new AccountEntity();
        account.setEmail(accountRequest.getEmail());
        account.setPassword(accountRequest.getPassword());
        account.setFullName(accountRequest.getFullName());
        account.setBirthday(accountRequest.getBirthday());

        return repository.save(account);

    }
}
