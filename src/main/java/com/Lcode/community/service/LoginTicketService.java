package com.Lcode.community.service;

import com.Lcode.community.dao.LoginTicketMapper;
import com.Lcode.community.entity.LoginTicket;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginTicketService {

    @Autowired
    private LoginTicketMapper loginTicketMapper;

    public void insertLoginTicket(LoginTicket loginTicket){
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    public LoginTicket selectByTicket(String ticket){
        return loginTicketMapper.selectByTicket(ticket);
    }

    public void updateStatus(String ticket, int status){
        loginTicketMapper.updateStatus(ticket, status);
    }
}
