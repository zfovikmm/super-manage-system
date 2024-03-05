package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.controller.UserController;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    public User login(User req){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",req.getUsername());
        User user = userMapper.selectOne(queryWrapper);
        LOG.info(String.valueOf(user));
        if(!ObjectUtils.isNull(user) && user.getPassword().equals(req.getPassword())){
            return user;
        }else {
            return null;
        }
    }

    public User getInfo(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username","admin");
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }
}
