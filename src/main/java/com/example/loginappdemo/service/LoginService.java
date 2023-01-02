package com.example.loginappdemo.service;

import com.example.loginappdemo.config.JwtTokenUtil;
import com.example.loginappdemo.entity.RequestModel;
import com.example.loginappdemo.entity.ResponseModel;
import com.example.loginappdemo.entity.User;
import com.example.loginappdemo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoginService {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepo userRepo;
    public ResponseEntity<ResponseModel> login(RequestModel requestModel){
        try {
            User user = userRepo.findByUsernameAndPassword(requestModel.getUsername(), requestModel.getPassword());
            if (user == null) {
                log.error("User Not Found");
                return new ResponseEntity<>(ResponseModel.builder()
                        .status("failed")
                        .message("Username or Password incorrect")
                        .build(), HttpStatus.BAD_REQUEST);
            }
            final String token = jwtTokenUtil.generateToken(requestModel);

            return ResponseEntity.ok(
                    ResponseModel.builder()
                            .data(token)
                            .message("login Success")
                            .status("success")
                            .build());
        } catch (Exception e){
            log.error("Exception | {}", e.getMessage());
            return new ResponseEntity<>(ResponseModel.builder()
                    .status("failed")
                    .message("Caught General Error")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
