package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestUserDao {
	@Autowired
	UserMapper userDao;
	
	@Test
	public void testselectByPrimaryKey(){
		User u = userDao.selectByPrimaryKey(1);
		System.out.println(u.getFeelWord());
	}
	@Test
	public void testInsert(){
		User user = new User();
		user.setAddDate(new Date());
		user.setEmail("1775924476@qq.com");
		user.setFeelWord("it is a goods day");
		user.setLastModifyDate(new Date());
		user.setPassword("aaaaaa");
		user.setPersonIntroduction("我是一个好人，但不会是雷锋一样的好人");
		user.setPhone("13672291886");
		user.setUserName("小花");
		userDao.insert(user);
	}
	@Test
	public void testDelete(){
		int delStatus = userDao.deleteByPrimaryKey(1);
		System.out.println(delStatus);
	}
}
