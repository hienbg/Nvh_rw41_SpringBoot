package com.vti.rw41.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ProductNameNotUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductNameNotUnique {

    String message() default "{error.productName.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
