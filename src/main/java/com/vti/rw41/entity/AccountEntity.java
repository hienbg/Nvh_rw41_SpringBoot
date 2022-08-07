package com.vti.rw41.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "`Accounts`")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;

    private String email;

    private String password;

    private String fullName;

    private LocalDate birthday;
}
