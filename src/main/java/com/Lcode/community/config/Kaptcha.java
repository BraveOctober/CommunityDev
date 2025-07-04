package com.Lcode.community.config;

import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class Kaptcha {

    @Bean
    public Producer kaptchaProducer()
    {
        Properties pro = new Properties();
        pro.setProperty("kaptcha.image.height","40");
        pro.setProperty("kaptcha.image.width","100");
        pro.setProperty("kaptcha.textproducer.font.size","32");
        pro.setProperty("kaptcha.textproducer.font.color","0,0,0");
        pro.setProperty("kaptcha.textproducer.char.string","0123456789ABCDEFGHIGKLMNOPQRSTUVWXYZ");
        pro.setProperty("kaptcha.textproducer.char.length","4");
        pro.setProperty("kaptcha.noise.impl","com.google.code.kaptcha.impl.NoNoise");

        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Config config = new Config(pro);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
