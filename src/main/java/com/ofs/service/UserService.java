package com.ofs.service;

import com.ofs.client.UserServiceClient;
import com.ofs.model.userservice.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserServiceClient userServiceClient;

    public Optional<User> getUserById(String id, String token) {
        return userServiceClient.getUserById(id, token);
    }
}
