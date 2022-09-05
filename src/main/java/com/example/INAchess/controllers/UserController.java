package com.example.INAchess.controllers;

import com.example.INAchess.controllers.requests.UserRequest;
import com.example.INAchess.models.UserModel;
import com.example.INAchess.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional
    @PostMapping
    public void createUser(@Validated @RequestBody UserRequest userRequest) {
        UserModel user = new UserModel();
        user.setUserName(userRequest.getUserName());
        userRepository.save(user);

    }
}
