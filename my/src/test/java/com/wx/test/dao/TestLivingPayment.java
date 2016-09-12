package com.wx.test.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.entity.LivingPayment;
import com.wx.pro.model.dao.LivingPaymentMapper;
import com.wx.pro.model.dao.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestLivingPayment {
	
	@Autowired
	private LivingPaymentMapper livePayDao;
	@Autowired
	private UserMapper userDao;
	
	@Test
	public void testAdd(){
		LivingPayment livePay = new LivingPayment();
		livePay.setAddDate(new Date());
		livePay.setDeleteStatus(1);
		livePay.setLastModifyDate(new Date());
		livePay.setName("16-9-12卖菜分摊");
		livePay.setShareInfo("{[user_id: 1,user_name: '小明',share_status: 1,share_time: 2016-8-1512: 34: 12],[user_id: 2,user_name: '小李子',share_status: 1,share_time: 2016-8-1512: 34: 12]}");
		livePay.setSpecId(1);
		livePay.setUserId(userDao.selectByPrimaryKey(1));
		
		livePayDao.insert(livePay);
	}
	
}
