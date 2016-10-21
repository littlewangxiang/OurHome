package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.UserBean;
import com.wx.pro.common.entity.User;

public interface IUserService {
	
	public User getObjectById(Integer id);
	
	public ResultMessage saveObject(UserBean usBean);
	
	public ResultMessage updateObject(User user);
	
	public Integer deleteObject(Integer id);
	
	public List<User> getUserByParam(UserBean userBean);
	
}
