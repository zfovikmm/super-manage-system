package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.example.controller.UserController;
import com.example.entity.User;
import com.example.exception.BusinessException;
import com.example.exception.BusinessExceptionCode;
import com.example.mapper.UserMapper;
import com.example.utils.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    public User login(User req){
        String token = null;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("username",req.getUsername());
        User user = userMapper.selectOne(queryWrapper);

        if(!ObjectUtils.isNull(user) && user.getPassword().equals(req.getPassword())){

            return user;
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
