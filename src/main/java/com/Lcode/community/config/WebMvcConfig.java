package com.Lcode.community.config;

import com.Lcode.community.controller.interceptor.LoginRequiredInterceptor;
import com.Lcode.community.controller.interceptor.LoginTicketInterceptor;
import com.Lcode.community.controller.interceptor.TestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private TestInterceptor testInterceptor;

    @Autowired
    private LoginTicketInterceptor loginTicketInterceptor;

    @Autowired
    private LoginRequiredInterceptor loginRequiredInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor)
                .excludePathPatterns("/**/*.js")
                .addPathPatterns("/login","/register");

        registry.addInterceptor(loginTicketInterceptor)
                .excludePathPatterns("/**/*.js","/**/*.png","/**/*.jpg","/**/*.jpeg","/**/*.css");

        registry.addInterceptor(loginRequiredInterceptor)
                .excludePathPatterns("/**/*.js","/**/*.png","/**/*.jpg","/**/*.jpeg","/**/*.css");
    }
}
