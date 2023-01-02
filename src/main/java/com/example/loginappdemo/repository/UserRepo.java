package com.example.loginappdemo.repository;

import com.example.loginappdemo.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User, String> {
    public User findByUsernameAndPassword(String username, String password);
}
