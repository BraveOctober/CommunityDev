package com.Lcode.community;

import com.Lcode.community.dao.DiscussPostMapper;
import com.Lcode.community.dao.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@MapperScan("com.Lcode.community.dao")
public class CommunityApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(CommunityApplication.class, args);
//		System.out.println("UserMapper Bean exists: " + (context.getBeanNamesForType(DiscussPostMapper.class).length > 0));
	}

}
