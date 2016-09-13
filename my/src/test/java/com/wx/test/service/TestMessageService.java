package com.wx.test.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.MessageBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.Message;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.MessageMapper;
import com.wx.pro.model.service.IMessageService;
import com.wx.pro.model.service.IUserService;
import com.wx.pro.model.service.impl.MessageServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestMessageService {
	
	@Autowired
	IMessageService msgService;
	@Autowired
	IUserService userService;
	
	@Test
	public void testGetList() throws InterruptedException{
		List<Message> listMsg = new ArrayList<Message>();
		Thread.sleep(10000);
		listMsg = msgService.getListMsgByUserId(userService.getObjectById(1));
		System.out.println(listMsg.size());
	}
	@Test
	public void testSendMsg(){
		MessageBean msgBean = new MessageBean();
		List<User> list = new ArrayList<User>();
		list.add(userService.getObjectById(2));
		msgBean.setGetUser(list);
		msgBean.setSendUser(userService.getObjectById(1));
		msgBean.setContent("您有一条通知：您需要及时支付所需承担的分摊费用");
		ResultMessage rsm = msgService.sendMessage(msgBean);
		System.out.println(rsm.getMessage());
	}
	@Test
	public void delMsg(){
		ResultMessage rsm = msgService.delMsg(1, userService.getObjectById(1));
		System.out.println(rsm.getMessage());
	}
	@Test
	public void testReaded(){
		ResultMessage rsm = msgService.changeStatusToReaded(4);
		System.out.println(rsm.getMessage());
	}
}
