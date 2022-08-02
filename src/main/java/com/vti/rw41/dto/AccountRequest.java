package com.vti.rw41.dto;

import com.vti.rw41.validation.EmailNotUnique;
import com.vti.rw41.validation.Password;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

@Data
public class AccountRequest {
    @Email
    @NotNull
    @EmailNotUnique
    private String email;

    @Password
    @Length(min = 6, max=12)
    private String password;

    @NotNull
    @Length(min=1, max=50)
    private String fullName;

    @Past
    private LocalDate birthday;

}
