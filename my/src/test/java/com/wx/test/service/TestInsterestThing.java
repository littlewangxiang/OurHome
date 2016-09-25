package com.wx.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.InsterestThingBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.InsterestThing;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.UserMapper;
import com.wx.pro.model.service.IIterestThing;
import com.wx.pro.model.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestInsterestThing {
	
	@Autowired
	private IIterestThing interestThService;
	@Autowired
	private IUserService userService;
	@Test
	public void testAdd(){
		User user = userService.getObjectById(2);
		
		InsterestThingBean insterestThingBean = new InsterestThingBean();
		insterestThingBean.setInfo("这是一天的中午，我没事在上地地铁闲逛。。。");
		
		insterestThingBean.setPublishUserId(user);
		ResultMessage rms = interestThService.addInsterestThing(insterestThingBean);
		System.out.println(rms.getMessage());
	}
	@Test
	public void delTest(){
		
		interestThService.delInsterestThing(1);
		
	}
	@Test
	public void getAllTest(){
		List<InsterestThing> list = interestThService.getAllInsterestThingsList();
		System.out.println(list.size());
	}
	
}
