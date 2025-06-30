package com.Lcode.community.controller;

import com.Lcode.community.entity.User;
import com.Lcode.community.service.UserService;
import com.Lcode.community.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class LoginController implements Constant {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "/register", method = RequestMethod.GET)
    public String getRegister()
    {
        return "/site/register";
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String getLogin()
    {
        return "/site/login";
    }

    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public String register(Model model, User user){
        Map<String,Object> map = userService.register(user);
        if (map.isEmpty() || map == null){
            model.addAttribute("msg","注册成功，已向您的邮箱发送激活邮件，请尽快查收");
            model.addAttribute("target","/index");
            return "/site/operate-result";
        }
        else {
            model.addAttribute("usernameMsg",map.get("usernameMsg"));
            model.addAttribute("emailMsg",map.get("emailMsg"));
            model.addAttribute("passwordMsg",map.get("passwordMsg"));
            return "/site/register";
        }
    }

    @RequestMapping(path = "/activation/{userId}/{code}", method = RequestMethod.GET)
    public String activation(Model model, @PathVariable("userId") int userId,
                             @PathVariable("code") String code)
    {
        int res = userService.activation(userId,code);
        if (res == ACTIVATION_SUCCESS){
            model.addAttribute("msg","激活成功");
            model.addAttribute("target","/login");
        }
        else if(res == ACTIVATION_REPEAT){
            model.addAttribute("msg","重复激活");
            model.addAttribute("target","/index");
        }
        else {
            model.addAttribute("msg","激活失败");
            model.addAttribute("target","/index");
        }
        return "/site/operate-result";
    }
}
