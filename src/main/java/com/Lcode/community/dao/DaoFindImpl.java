package com.Lcode.community.dao;

import org.springframework.stereotype.Repository;

@Repository
public class DaoFindImpl implements DaoFind{

    @Override
    public String select() {
        return "Daofind";
    }
}
