package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.Message;
import com.wx.pro.model.dao.MessageMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestMessage {
	@Autowired
	private MessageMapper messageDao;
	
	@Test
	public void testAdd(){
		Message message = new Message();
		message.setAddDate(new Date());
		message.setDeleteStatus(1);
		message.setLastModifyDate(new Date());
		message.setMessageInfo("您参与的购物分摊请及时转账哦");
		message.setMsgType(1);
		messageDao.insert(message);
	}
}
