package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.InsterestThingDiscuss;
import com.wx.pro.model.dao.InsterestThingDiscussMapper;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestInsterestThingDiscuss {
	
	@Autowired
	private InsterestThingDiscussMapper insterestDiscussDao;
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void testAdd(){
		InsterestThingDiscuss insterestDiscuss = new InsterestThingDiscuss();
		insterestDiscuss.setAddDate(new Date());
		insterestDiscuss.setCommentInfo("我也去过这里");
		insterestDiscuss.setDeleteStatus(1);
		insterestDiscuss.setInsterestThingId(1);
		insterestDiscuss.setLastModifyDate(new Date());
		insterestDiscuss.setParentDiscussId(null);
		insterestDiscuss.setUserId(userDao.selectByPrimaryKey(1));
		insterestDiscussDao.insert(insterestDiscuss);
	}
	@Test
	public void testselect(){
		InsterestThingDiscuss ihd = insterestDiscussDao.selectByPrimaryKey(1);
		System.out.println(ihd.getCommentInfo());
	}
}
