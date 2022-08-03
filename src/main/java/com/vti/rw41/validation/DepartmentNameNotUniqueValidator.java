package com.vti.rw41.validation;

import com.vti.rw41.repository.DepartmentRepository;
import com.vti.rw41.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DepartmentNameNotUniqueValidator implements ConstraintValidator<DepartmentNameNotUnique, String> {
    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        return departmentRepository.isDepartmentNameNotExists(name);
    }
}
