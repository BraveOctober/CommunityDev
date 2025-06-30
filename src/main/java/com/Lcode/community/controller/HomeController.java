package com.Lcode.community.controller;

import com.Lcode.community.entity.DiscussPost;
import com.Lcode.community.entity.Page;
import com.Lcode.community.service.DiscussPostService;

import com.Lcode.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    public String getInitialPage(Model model, Page page){
        page.setTotalLine(discussPostService.findCount(0));
        page.setPath("/index");
        List<DiscussPost> discussPosts = discussPostService.findDiscussPost(0,page.getStartId(),page.getLimit());
        List<Map<String, Object>> res = new ArrayList<>();
        if (discussPosts != null)
        {
            for (DiscussPost disPosts : discussPosts)
            {
                Map<String, Object> map = new HashMap<>();
                map.put("post",disPosts);
                map.put("user",userService.findUserById(disPosts.getUserId()));
                res.add(map);
            }
        }
        model.addAttribute("res",res);
        return "/index";
    }
}
