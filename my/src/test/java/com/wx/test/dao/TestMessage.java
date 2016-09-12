package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.Message;
import com.wx.pro.model.dao.MessageMapper;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestMessage {
	@Autowired
	private MessageMapper messageDao;
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void testAdd(){
		Message message = new Message();
		message.setAddDate(new Date());
		message.setDeleteStatus(1);
		message.setLastModifyDate(new Date());
		message.setMessageInfo("您参与的分摊该交钱了");
		message.setMsgType(1);
		message.setSendUser(userDao.selectByPrimaryKey(1));
		message.setGetUser(userDao.selectByPrimaryKey(2));
		messageDao.insert(message);
	}
}
