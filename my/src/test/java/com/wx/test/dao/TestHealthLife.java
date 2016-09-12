package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.HealthLife;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.HealthLifeMapper;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestHealthLife {
	@Autowired
	private HealthLifeMapper healthLifeDao;
	@Autowired
	private UserMapper userDao;
	@Test
	public void testSelect(){
		HealthLife health = healthLifeDao.selectByPrimaryKey(1);
		System.out.println(health.getLifeHealthName());
	}
	
	@Test
	public void testAddHealth(){
		User user = userDao.selectByPrimaryKey(1);
		
		if(user!=null){
			HealthLife health = new HealthLife();
			health.setAddDate(new Date());
			health.setDeleteStatus(1);
			health.setLastModifyDate(new Date());
			health.setLifeHealthName("每天健康");
			health.setUserId(user);
			int a = healthLifeDao.insert(health);
			System.out.println(a);
		}
		
	}
}
