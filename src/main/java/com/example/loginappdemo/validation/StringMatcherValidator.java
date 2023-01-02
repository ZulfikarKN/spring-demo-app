package com.example.loginappdemo.validation;

import com.example.loginappdemo.validation.annotation.Matched;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StringMatcherValidator implements ConstraintValidator<Matched, String> {

    private String regex;

    @Override
    public void initialize(Matched constraintAnnotation) {
        this.regex = constraintAnnotation.regex();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext ctx) {
        return s != null && s.matches(regex);
    }
}
