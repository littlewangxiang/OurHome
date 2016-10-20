package com.wx.test.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wx.pro.common.bean.LivingPaymentBean;
import com.wx.pro.common.bean.ShareInfoBean;
import com.wx.pro.common.entity.LivingPayment;
import com.wx.pro.model.service.ILivingPaymentService;
import com.wx.pro.model.service.IUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestLivingPayment {
	
	@Autowired
	private ILivingPaymentService livePayService;
	@Autowired
	private IUserService userService;
	
	
	@Test
	public void testAddOneLivePayment(){
		LivingPaymentBean livePayBean = new LivingPaymentBean();
		List<ShareInfoBean> shareInfoBeans = new ArrayList<ShareInfoBean>();
		
		livePayBean.setName("购物分摊今天的");
		livePayBean.setSpecName("物美超市");
		livePayBean.setUser(userService.getObjectById(1));
		
		shareInfoBeans.add(new ShareInfoBean(2, "小花"));
		shareInfoBeans.add(new ShareInfoBean(3, "小王"));
		
		livePayService.addALivingPayment(livePayBean, shareInfoBeans);
		
	}
	@Test
	public void testgetLivingPayment(){
		LivingPaymentBean livingPaymentBean = new LivingPaymentBean();
		livingPaymentBean.setName("购物分摊今天的");
		
		List<LivingPayment> livePays = livePayService.getLivingPayment(livingPaymentBean);
		System.out.println(livePays.size());
		
	}
	@Test
	public void testdelLivingPayment(){
		livePayService.delLivingPayment(1);
	}
	@Test
	public void testupdateLivingPaymet(){
		LivingPayment livepay = livePayService.getLivingPaymentById(1);
		livepay.setLastModifyDate(new Date());
		livePayService.updateLivingPaymet(livepay);
	}
}
