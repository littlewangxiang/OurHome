package com.wx.pro.model.service;

import com.wx.pro.common.entity.User;

public interface IUserService {
	
	public User getObjectById(Integer id);
	
	public Integer saveObject(User user);
	
	public Integer updateObject(User user);
	
	public Integer deleteObject(Integer id);
	
}
