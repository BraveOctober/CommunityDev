package com.Lcode.community.service;

import com.Lcode.community.dao.DiscussPostMapper;
import com.Lcode.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> findDiscussPost(int userId, int startId, int limit)
    {
        return discussPostMapper.selectDiscussPost(userId, startId, limit);
    }

    public int findCount(int userId)
    {
        return discussPostMapper.selectCount(userId);
    }
}
