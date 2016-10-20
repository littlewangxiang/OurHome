package com.wx.test.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.InsterestThingDiscussBean;
import com.wx.pro.common.entity.InsterestThingDiscuss;
import com.wx.pro.model.service.IInterestThingDiscussService;
import com.wx.pro.model.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestInsterestThingDiscussService {
	
	@Autowired
	IInterestThingDiscussService insterestThingDiscussService;
	@Autowired
	IUserService userService;
	
	@Test
	public void testAdd(){
		InsterestThingDiscussBean insterestThDis = new InsterestThingDiscussBean();
		insterestThDis.setCommentInfo("我来评论一个");
		insterestThDis.setInsterestThingId(1);
		insterestThDis.setParentDiscussId(null);
		insterestThDis.setUserId(userService.getObjectById(1));
		
		insterestThingDiscussService.addOneDiscuss(insterestThDis);
	}
	
	@Test
	public void testgetByIntId(){
		List<InsterestThingDiscuss> list = insterestThingDiscussService.getDiscussByInsterestThingId(2);
		System.out.println(list.size());
	}
	
	
}
