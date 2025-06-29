package com.Lcode.community;

import com.Lcode.community.dao.DiscussPostMapper;
import com.Lcode.community.dao.UserMapper;
import com.Lcode.community.entity.DiscussPost;
import com.Lcode.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testUserSelect()
    {
        User user = userMapper.selectById(1);
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder11@sina.com");
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    public void testDiscussSelect()
    {
        List<DiscussPost> disList = discussPostMapper.selectDiscussPost(0,5,10);
        for (DiscussPost ele : disList)
        {
            System.out.println(ele);
        }

        int count = discussPostMapper.selectCount(149);
        System.out.println(count);

    }
}
