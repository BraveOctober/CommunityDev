package com.Lcode.community.controller;

import com.Lcode.community.annotation.LoginRequired;
import com.Lcode.community.entity.User;
import com.Lcode.community.service.UserService;
import com.Lcode.community.util.CommunityUtil;
import com.Lcode.community.util.HostHolder;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private HostHolder hostHolder;

    @Value("${server.user.image.path}")
    private String imageDataPath;

    @Value("${community.path.domain}")
    private String domain;

    @Value("${server.servlet.context-path}")
    private String contentPath;

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @LoginRequired
    @RequestMapping(path = "/setting", method = RequestMethod.GET)
    public String getSetting(){
        return "/site/setting";
    }

    @LoginRequired
    @RequestMapping(path = "/image", method = RequestMethod.POST)
    public String getImage(MultipartFile headerImage, Model model){
        if (headerImage == null){
            model.addAttribute("error", "未上传图片");
            return "/site/setting";
        }
        //将文件存到服务器
        String filename = headerImage.getOriginalFilename(); //获取用户上传的文件名
        String suffix = filename.substring(filename.lastIndexOf("."));
        if (suffix == null){
            model.addAttribute("error", "图片格式不正确");
            return "/site/setting";
        }
        String serverPath = CommunityUtil.getUUID() + suffix;
        File imageFile = new File(imageDataPath + "/" + serverPath);
        try {
            headerImage.transferTo(imageFile);
        } catch (IOException e) {
            logger.error("图片存储失败" + e.getMessage());
        }
        //将用户的头像文件名修改
        User user = hostHolder.getUser();
        userService.updateHeader(user.getId(), domain + contentPath + "/user/image/" + serverPath);
        return "redirect:/index";
    }

    @RequestMapping(path = "/image/{header}", method = RequestMethod.GET)
    public void setHeader(@PathVariable("header") String header, HttpServletResponse response){
        String filename = imageDataPath + "/" + header;
        String suffix = header.substring(header.lastIndexOf("."));
        response.setContentType("image/" + suffix);
        try (OutputStream os = response.getOutputStream();
             FileInputStream in = new FileInputStream(filename);){
            byte[] buffer = new byte[1024];
            int b = 0;
            while ((b = in.read(buffer)) != -1){
                os.write(buffer,0, b);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
