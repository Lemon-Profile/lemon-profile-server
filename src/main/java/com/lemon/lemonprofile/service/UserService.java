package com.lemon.lemonprofile.service;

import com.lemon.lemonprofile.mapper.UserMapper;
import com.lemon.lemonprofile.model.TbUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<TbUserVo> getUsers() {
        return userMapper.getUser();
    }

}
