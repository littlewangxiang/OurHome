package com.wx.pro.common.bean;

import com.wx.pro.common.entity.User;

public class LivingPaymentBean {
	
	private String name;//生活支付分摊简称
	
	private User user;//发起者
	
	private String specName;//缴费项目简称

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getSpecName() {
		return specName;
	}

	public void setSpecName(String specName) {
		this.specName = specName;
	}
}
