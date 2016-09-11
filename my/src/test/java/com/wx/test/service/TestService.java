package com.wx.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.HealthLifeBean;
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
		HealthLife health = healthLifeService.getObjectById(1);
		System.out.println(health.getLifeHealthName());
	}
	@Test
	public void testAddUser(){
		HealthLifeBean healthBean = new HealthLifeBean();
		
		healthBean.setLifeHealthName("ньнь╨ц╨ц");
		User user = userService.getObjectById(1);
		healthBean.setUserId(user);
		
		healthLifeService.addHealthLife(healthBean);
		
	}
}
