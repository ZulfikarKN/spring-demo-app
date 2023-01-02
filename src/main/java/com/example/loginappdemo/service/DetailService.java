package com.example.loginappdemo.service;

import com.example.loginappdemo.config.JwtTokenUtil;
import com.example.loginappdemo.entity.User;
import com.example.loginappdemo.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class DetailService {
    RestTemplate restTemplate = new RestTemplate();
    @Value("${detail.uri}")
    String detailUri;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserRepo userRepo;
    public ResponseEntity<String> getDetail(String token, String ID){
        try {
            String tokenStr = jwtTokenUtil.getStrToken(token);
            String username = tokenStr.split("-")[0];
            String password = tokenStr.split("-")[1];

            User user = userRepo.findByUsernameAndPassword(username, password);
            if (user == null) {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
            String response = restTemplate.getForObject(detailUri, String.class, ID);
            log.info("Response: {}", response);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Exception | {}", e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
