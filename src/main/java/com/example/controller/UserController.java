package com.example.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.entity.CommonResp;

import com.example.entity.User;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.HashMap;

@RestController
@RequestMapping("/user")
public class UserController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResp login(@RequestBody User req, HttpServletRequest request, HttpServletResponse response) throws Exception{
        CommonResp<User> resp = new CommonResp<>();
        User login = userService.login(req);
        resp.setData(login);
        HashMap<String, Object> hashMap = new HashMap<>();
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND,20);
        String token = JWT.create()
                .withHeader(hashMap)
                .withClaim("userid",login.getUId())
                .withClaim("username",login.getUsername())
                .withExpiresAt(instance.getTime())
                .sign(Algorithm.HMAC256("123123123"));
        return resp;
    }

    @GetMapping("/info")
    public CommonResp getInfo(){
        CommonResp<User> resp = new CommonResp<>();
        resp.setData(userService.getInfo());
        return resp;
    }
}
