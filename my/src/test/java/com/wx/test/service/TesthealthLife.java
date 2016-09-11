package com.wx.test.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.HealthLifeBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.HealthLife;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.service.IHealthLife;
import com.wx.pro.model.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TesthealthLife {

	@Autowired
	private IHealthLife healthLifeService;
	@Autowired
	private IUserService userService;
	
	@Test
	public void addHealthLife() {
		HealthLifeBean healthBean = new HealthLifeBean();

		healthBean.setLifeHealthName("ÎØÎØºÃºÃ");
		User user = userService.getObjectById(1);
		healthBean.setUserId(user);

		healthLifeService.addHealthLife(healthBean);
	}
	@Test
	public void editHealthLife(){
		HealthLife healthLife = healthLifeService.getObjectById(1);
		healthLife.setLifeHealthName("¹þ¹þ");
		ResultMessage rsm = healthLifeService.editHealthLife(healthLife);
		System.out.println(rsm.getStatus()+"   "+rsm.getMessage());
	}
	
	@Test
	public void delHealthLife(){
		healthLifeService.delHealthLife(1);
	}
}
