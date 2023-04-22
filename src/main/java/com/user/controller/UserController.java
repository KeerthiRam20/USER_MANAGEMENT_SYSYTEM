package com.user.controller;

import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(value="/list")
    public Iterable<User> list() {

        return userService.list();
    }

//    @GetMapping("/user")
//    public ResponseEntity <list<User>> getallUsers(){
//        List<User> allUsers = userService.getallUsers();
//        return new ResponseEntity<List<User>> (allUsers);
//    }
}
