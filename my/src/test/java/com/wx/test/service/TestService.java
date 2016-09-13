package com.wx.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.HealthLifeBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.UserBean;
import com.wx.pro.common.entity.HealthLife;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.service.IHealthLife;
import com.wx.pro.model.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestService {
	
	@Autowired
	private IHealthLife healthLifeService;
	@Autowired
	private IUserService userService;
	
	@Test
	public void testGetUser(){
		User user = userService.getObjectById(1);
		System.out.println(user);
	}
	@Test
	public void testAddUser(){
		UserBean usBean = new UserBean();
		usBean.setUserName("小王");
		usBean.setPassword("wx132");
		usBean.setPhone("12312412");
		ResultMessage rsm = userService.saveObject(usBean);
		System.out.println(rsm.getMessage());
	}
	@Test
	public void test(){
		User user = userService.getObjectById(1);
		user.setEmail("123@yu.com");
		user.setUserName("水瓶");
		ResultMessage rsm = userService.updateObject(user);
		System.out.println(rsm.getMessage());
	}
	@Test
	public void testDel(){
		userService.deleteObject(1);
	}
}
