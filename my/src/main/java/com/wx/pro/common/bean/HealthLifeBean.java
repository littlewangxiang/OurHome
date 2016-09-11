package com.wx.pro.common.bean;

import com.wx.pro.common.entity.User;

public class HealthLifeBean {
	
	private String lifeHealthName;
	
	private User userId;

	public String getLifeHealthName() {
		return lifeHealthName;
	}

	public void setLifeHealthName(String lifeHealthName) {
		this.lifeHealthName = lifeHealthName;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}
	
}
