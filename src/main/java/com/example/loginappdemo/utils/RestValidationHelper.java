package com.example.loginappdemo.utils;
import com.example.loginappdemo.entity.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import java.util.Objects;

@Slf4j
public class RestValidationHelper {
    private RestValidationHelper() {

    }
    public static boolean fieldValidation(BindingResult result, ResponseModel response){
        if (result != null && result.hasErrors()) {
            response.setStatus(String.valueOf(HttpStatus.BAD_REQUEST.value()));
            response.setMessage(Objects.requireNonNull(result.getFieldError()).getField() + " - " + Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            log.error(Objects.requireNonNull(result.getFieldError()).getField() + " - " + Objects.requireNonNull(result.getFieldError()).getDefaultMessage());
            return false;
        }
        return true;
    }
}
