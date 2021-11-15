package id.liostech.springpus.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.liostech.springpus.entities.User;
import id.liostech.springpus.models.UserCreateRequest;
import id.liostech.springpus.services.UserService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value="create")
    public User createUser(@RequestBody UserCreateRequest userCreateRequest) {
        return userService.create(userCreateRequest);
    }

    @PostMapping(value = "register")
    public User registerUser(@RequestBody UserCreateRequest userCreateRequest){
        return userService.registerUser(userCreateRequest);
    }
    
}
