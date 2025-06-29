package com.Lcode.community.service;

import com.Lcode.community.dao.DaoFind;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerFind {

    @Autowired
    private DaoFind daoFind;

    public String find(){
        return daoFind.select();
    }

    public SerFind(){
        System.out.println("构造");
    }

    @PostConstruct
    public void init()
    {
        System.out.println("初始化");
    }

    @PreDestroy
    public void destory()
    {
        System.out.println("销毁");
    }
}
