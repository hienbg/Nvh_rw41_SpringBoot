package com.vti.rw41.dto;

import com.vti.rw41.validation.DepartmentNameNotUnique;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class DepartmentRequest {
    @NotNull
    @NotBlank
    @Length(min = 5, max = 10)
    @DepartmentNameNotUnique
    private String name;
}
