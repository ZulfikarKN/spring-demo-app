package com.example.loginappdemo.entity;

import com.example.loginappdemo.validation.annotation.Matched;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RequestModel {
    @Matched(regex = "^[^%<>^$\\-]+$", message = "only alphabets and white spaces")
    protected String username;
    @Matched(regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
            , message = "atleast 8 char long, one Capital, digits, and Special Character")
    protected String password;
}
