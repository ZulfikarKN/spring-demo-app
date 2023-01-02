package com.example.loginappdemo.controller;

import com.example.loginappdemo.config.JwtTokenUtil;
import com.example.loginappdemo.entity.RequestModel;
import com.example.loginappdemo.entity.ResponseModel;
import com.example.loginappdemo.entity.ResponseModel;
import com.example.loginappdemo.entity.User;
import com.example.loginappdemo.repository.UserRepo;
import com.example.loginappdemo.service.DetailService;
import com.example.loginappdemo.service.GetListService;
import com.example.loginappdemo.service.LoginService;
import com.example.loginappdemo.service.RegisterService;
import com.example.loginappdemo.utils.RestValidationHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class Controller {
    @Autowired
    LoginService loginService;
    @Autowired
    RegisterService registerService;
    @Autowired
    GetListService getListService;
    @Autowired
    DetailService detailService;
    @PostMapping(value = "/login", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseModel> login(
            @Validated @RequestBody RequestModel requestModel, BindingResult result) {
        ResponseModel response = ResponseModel.builder().build();
        if (!RestValidationHelper.fieldValidation(result, response)) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return loginService.login(requestModel);
    }

    @PostMapping(value= "/register", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ResponseModel> register(
            @Validated @RequestBody RequestModel requestModel, BindingResult result) {
        ResponseModel response = ResponseModel.builder().build();

        if (!RestValidationHelper.fieldValidation(result, response)) {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
        return registerService.regist(requestModel);
    }

    @GetMapping(value = "/job-list", produces = "application/json")
    public ResponseEntity<String> getList(@RequestHeader(value = "token") String token){
        return getListService.getList(token);
    }

    @GetMapping(value = "/job-detail/{id}", produces = "application/json")
    public ResponseEntity<String> getDetail(@RequestHeader(value = "token") String token, @PathVariable String id){
        return detailService.getDetail(token, id);
    }
}
