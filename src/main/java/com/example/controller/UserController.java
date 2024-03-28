package com.example.controller;

import com.example.entity.CommonResp;
import com.example.entity.User;
import com.example.exception.BusinessException;
import com.example.exception.BusinessExceptionCode;
import com.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {


    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public CommonResp login(@RequestBody User req) {
        return  userService.login(req);
    }

    @GetMapping("/info")
    public CommonResp getInfo(){
        CommonResp<User> resp = new CommonResp<>();
        resp.setData(userService.getInfo());
        return resp;
    }

    @GetMapping("/test")
    public String test(){
        return "123123123";
    }
}
