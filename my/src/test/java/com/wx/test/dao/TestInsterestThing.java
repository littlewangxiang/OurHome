package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.InsterestThing;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.InsterestThingMapper;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestInsterestThing {
	
	@Autowired
	private InsterestThingMapper insterestThingDao; 
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void testGetObjById(){
		InsterestThing interest = insterestThingDao.selectByPrimaryKey(1);
		System.out.println(interest.getInfo());
	}
	@Test
	public void testAdd(){
		InsterestThing insterest = new InsterestThing();
		User user = userDao.selectByPrimaryKey(1);
		insterest.setAddDate(new Date());
		insterest.setLastModifyDate(new Date());
		insterest.setInfo("第一个奇闻异事");
		insterest.setPublishUserId(user);
		insterestThingDao.insert(insterest);
	}
}
