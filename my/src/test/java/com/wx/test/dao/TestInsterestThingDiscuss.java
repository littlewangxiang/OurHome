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
		insterestDiscuss.setCommentInfo("我也看过");
		insterestDiscuss.setDeleteStatus(1);
		insterestDiscuss.setInsterestThingId(1);
		insterestDiscuss.setLastModifyDate(new Date());
		insterestDiscuss.setParentDiscussId(null);
		insterestDiscuss.setUserId(userDao.selectByPrimaryKey(1));
		insterestDiscussDao.insert(insterestDiscuss);
	}
	@Test
	public void testAddSelective(){
		InsterestThingDiscuss insterestDiscuss = new InsterestThingDiscuss();
		insterestDiscuss.setAddDate(new Date());
		insterestDiscuss.setCommentInfo("我也看过1");
		insterestDiscuss.setDeleteStatus(1);
		insterestDiscuss.setInsterestThingId(1);
		insterestDiscuss.setLastModifyDate(new Date());
		insterestDiscuss.setParentDiscussId(null);
		insterestDiscuss.setUserId(userDao.selectByPrimaryKey(1));
		insterestDiscussDao.insertSelective(insterestDiscuss);
	}
	@Test
	public void testselect(){
		InsterestThingDiscuss insterestdiscuss = insterestDiscussDao.selectByPrimaryKey(1);
		System.out.println(insterestdiscuss.getCommentInfo());
	}
	@Test
	public void testupdateByPrimaryKeySelective(){
		InsterestThingDiscuss insterestdiscuss = insterestDiscussDao.selectByPrimaryKey(1);
		insterestdiscuss.setLastModifyDate(new Date());
		
		insterestDiscussDao.updateByPrimaryKey(insterestdiscuss);
	}
	
	@Test
	public void testupdateByPrimaryKey(){
		InsterestThingDiscuss insterestdiscuss = insterestDiscussDao.selectByPrimaryKey(1);
		insterestdiscuss.setLastModifyDate(new Date());
		
		insterestDiscussDao.updateByPrimaryKeySelective(insterestdiscuss);
	}
}
