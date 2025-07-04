package com.Lcode.community.controller;

import com.Lcode.community.service.SerFind;
import com.Lcode.community.util.CommunityUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@Controller
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/res")
    @ResponseBody
    public String response()
    {
        return "Hello";
    }

    @Autowired
    private SerFind serFind;

    @RequestMapping("/find")
    @ResponseBody
    public String find(){
        return serFind.find();
    }

    @RequestMapping(path = "/http")
    public void Http(HttpServletRequest request, HttpServletResponse response)
    {
        //获取请求报文
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration enumeration = request.getHeaderNames();
        while(enumeration.hasMoreElements())
        {
            String name = (String) enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+":"+value);
        }

        //获取响应报文
        response.setContentType("text/html;charset=utf-8");
        try (PrintWriter writer = response.getWriter();){
            writer.write("<p>响应测试</p>");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
//Post测试
    @RequestMapping(path = "/school", method = RequestMethod.POST)
    @ResponseBody
    public String getPara(String name, int age){
        System.out.println(name + ":" + age);
        return "success";
    }

    //html测试
    @RequestMapping(path = "/view", method = RequestMethod.GET)
    public String getHtml(Model model){
        model.addAttribute("name","张三");
        return "/test/view";
    }

    @RequestMapping(path = "/cookie/set", method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse response)
    {
        Cookie cookie = new Cookie("code", CommunityUtil.getUUID());
        cookie.setPath("/community/test");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
        return "set cookie";
    }
    @RequestMapping(path = "/cookie/get", method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code)
    {
        System.out.println(code);
        return "get cookie";
    }

    @RequestMapping(path = "/session/set", method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session)
    {
        session.setAttribute("id", 1);
        return "set session";
    }

    @RequestMapping(path = "/session/get", method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session)
    {
        session.getAttribute("id");
        return "get session";
    }


}
