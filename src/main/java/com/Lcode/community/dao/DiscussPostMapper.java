package com.Lcode.community.dao;

import com.Lcode.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {
    List<DiscussPost> selectDiscussPost(int userId, int startId, int limit);

    int selectCount(@Param("userId") int userId);
}
