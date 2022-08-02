package com.vti.rw41.validation;

import com.vti.rw41.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailNotUniqueValidator implements ConstraintValidator<EmailNotUnique, String> {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return accountRepository.isEmailNotExists(email);
    }
}
