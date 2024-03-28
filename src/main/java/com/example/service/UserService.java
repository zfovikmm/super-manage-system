package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.controller.UserController;
import com.example.entity.CommonResp;
import com.example.entity.User;
import com.example.exception.BusinessException;
import com.example.exception.BusinessExceptionCode;
import com.example.mapper.UserMapper;
import com.example.utils.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private JWTUtils jwtUtils;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    public CommonResp login(User req){
        CommonResp<User> resp = new CommonResp<>();
        String token;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",req.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        if(!ObjectUtils.isNull(user) && user.getPassword().equals(req.getPassword())){
            token = jwtUtils.createToken(user.getUsername());
            resp.setToken(token);
            resp.setData(user);
            resp.setMessage("登录成功");
            return resp;
        }else {
            throw new BusinessException(BusinessExceptionCode.LOGIN_USER_ERROR);
        }
    }

    public User getInfo(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username","admin");
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }
}
