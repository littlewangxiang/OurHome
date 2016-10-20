package com.wx.pro.common.bean;

public class ShareInfoBean {
	private Integer userId;//用户id
	
	private String userName;//用户名称

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public ShareInfoBean(){}
	
	public ShareInfoBean(Integer userId, String userName){
		this.userId = userId;
		this.userName = userName;
	}
	
}
