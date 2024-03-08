package com.example.controller;


import com.example.entity.CommonResp;

import com.example.entity.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResp login(@RequestBody User req, HttpSession session) throws Exception{
        CommonResp<User> resp = new CommonResp<>();
        resp.setData(userService.login(req));
        session.setAttribute("username",req.getUsername());
        return resp;
    }

    @GetMapping("/info")
    public CommonResp getInfo(){
        CommonResp<User> resp = new CommonResp<>();
        resp.setData(userService.getInfo());
        return resp;
    }
}
