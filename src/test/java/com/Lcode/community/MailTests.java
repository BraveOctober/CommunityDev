package com.Lcode.community;

import com.Lcode.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {
    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSend(){
        mailClient.sendMail("3243163782@qq.com", "Test", "喜欢");
    }

    @Test
    public void testHtmlSend(){
        Context context = new Context();
        context.setVariable("username","余翔");

        String content = templateEngine.process("/mail/mailtest",context);
        mailClient.sendMail("1006629729@qq.com", "Test", content);
//        mailClient.sendMail("3243163782@qq.com", "Test", content);
    }
}
