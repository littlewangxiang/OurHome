package com.wx.pro.model.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.UserMapper;
import com.wx.pro.model.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userDao;

	@Override
	public User getObjectById(Integer id) {
		// TODO Auto-generated method stub
		return userDao.selectByPrimaryKey(id);
	}

	@Override
	public Integer saveObject(User user) {
		// TODO Auto-generated method stub
		int res = -1;
		if (!StringUtils.isEmpty(user.getUserName())) {
			user.setLastModifyDate(new Date());
			if (user.getuId() != null) {
				user.setAddDate(new Date());
				res = userDao.insert(user);
			} else {
				res = userDao.updateByPrimaryKey(user);
			}
		}
		return res;
	}

	@Override
	public Integer updateObject(User user) {
		// TODO Auto-generated method stub
		return saveObject(user);
	}

	@Override
	public Integer deleteObject(Integer id) {
		// TODO Auto-generated method stub
		Integer res = -1;
		if(!StringUtils.isEmpty(id))
			res = userDao.deleteByPrimaryKey(id);
		return res;
	}

}
