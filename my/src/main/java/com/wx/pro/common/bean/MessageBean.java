package com.wx.pro.common.bean;

import java.util.List;

import com.wx.pro.common.entity.User;

public class MessageBean {
	private String content;
	
	private User sendUser;
	
	private List<User>getUser;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getSendUser() {
		return sendUser;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	public List<User> getGetUser() {
		return getUser;
	}

	public void setGetUser(List<User> getUser) {
		this.getUser = getUser;
	}
	
}
