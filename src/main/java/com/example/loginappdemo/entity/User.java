package com.example.loginappdemo.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
@Builder
@ToString
@Document(collection = "user")
public class User {
    private String username;
    private String password;
    private String created;

    public static String generateTimeRequest() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
        String timeRequest = format.format(now);
        return timeRequest;
    }
}
