package com.vti.rw41.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DepartmentNameNotUniqueValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DepartmentNameNotUnique {

    String message() default "{error.departmentName.unique}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
