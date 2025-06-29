package com.Lcode.community;

import com.Lcode.community.dao.DaoFind;
import com.Lcode.community.dao.UserMapper;
import com.Lcode.community.entity.User;
import com.Lcode.community.service.SerFind;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	public void testDao(){
		DaoFind daoFind = applicationContext.getBean(DaoFind.class);
		System.out.println(daoFind.select());
	}

	@Autowired
	private SerFind serFind;

	@Test
	public void testService()
	{
		System.out.println(serFind);
	}

}
