package com.jwt.jwtauthenticationserver.service;

import com.jwt.jwtauthenticationserver.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(UUID.randomUUID().toString(), "Rahul","rahul@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(), "Roshan","roshan@gmail.com"));
    }

    public List<User> getUsers(){
        return users;
    }
}
