package com.example.loginappdemo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseModel {
    protected String status;
    protected String message;
    protected Object data;
}
