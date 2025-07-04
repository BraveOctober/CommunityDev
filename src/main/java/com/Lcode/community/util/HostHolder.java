package com.Lcode.community.util;

import com.Lcode.community.entity.User;
import org.springframework.stereotype.Component;

@Component
/**
 * 用来存储用户信息，线程中
 */
public class HostHolder {
    private ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public void setUser(User user){
        userThreadLocal.set(user);
    }

    public User getUser(){
        return userThreadLocal.get();
    }

    public void removeUser(){
        userThreadLocal.remove();
    }
}
