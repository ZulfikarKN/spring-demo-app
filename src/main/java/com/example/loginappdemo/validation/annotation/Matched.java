package com.example.loginappdemo.validation.annotation;

import com.example.loginappdemo.validation.StringMatcherValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StringMatcherValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Matched {
    String message() default "Not Expected Value";

    String regex() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
