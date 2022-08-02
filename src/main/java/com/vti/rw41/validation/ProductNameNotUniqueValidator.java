package com.vti.rw41.validation;

import com.vti.rw41.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ProductNameNotUniqueValidator implements ConstraintValidator<ProductNameNotUnique, String> {
    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean isValid(String productName, ConstraintValidatorContext context) {
        return productRepository.isProductNameNotExists(productName);
    }



}
