package com.example.loginappdemo.service;

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
public class RegisterService {
    @Autowired
    private UserRepo userRepo;
    public ResponseEntity<ResponseModel> regist(RequestModel requestModel){
        String username = requestModel.getUsername();
        String password = requestModel.getPassword();
        try {
            User user = userRepo.findByUsernameAndPassword(username, password);
            if (user != null) {
                log.error("Data Already Existed!");
                return new ResponseEntity<>(ResponseModel.builder()
                        .status("failed")
                        .message("Data Already Exist")
                        .data(user)
                        .build(), HttpStatus.BAD_REQUEST);
            }
            user = User.builder()
                    .username(username)
                    .password(password)
                    .created(User.generateTimeRequest()).build();

            log.info("saving user info");
            userRepo.save(user);
            return ResponseEntity.ok(
                    ResponseModel.builder()
                            .status("success")
                            .message("Data Registered")
                            .data(user)
                            .build());
        } catch (Exception e) {
            log.error("Exception | {}", e.getMessage());
            return new ResponseEntity<>(ResponseModel.builder()
                    .status("failed")
                    .message("Caught General Error")
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
