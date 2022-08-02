package com.vti.rw41.controller;

import com.vti.rw41.dto.AccountRequest;
import com.vti.rw41.entity.AccountEntity;
import com.vti.rw41.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    AccountService accountService;
    @PostMapping("/register")
    public AccountEntity registerAccount(@Valid @RequestBody AccountRequest request) {

        return accountService.register(request);
    }
}
