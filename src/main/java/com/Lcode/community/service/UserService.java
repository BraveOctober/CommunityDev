package com.Lcode.community.service;

import com.Lcode.community.dao.UserMapper;
import com.Lcode.community.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findUser(int id)
    {
        return userMapper.selectById(id);
    }
}
