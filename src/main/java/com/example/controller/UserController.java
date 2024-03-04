package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public boolean login(@RequestBody User req){
        LOG.info(req.getUsername()+" "+req.getPassword());
        return userService.login(req);
    }

}
