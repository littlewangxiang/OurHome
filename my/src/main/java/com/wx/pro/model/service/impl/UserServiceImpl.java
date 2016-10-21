package com.wx.pro.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.UserBean;
import com.wx.pro.common.entity.User;
import com.wx.pro.common.tools.UserTools;
import com.wx.pro.model.dao.UserMapper;
import com.wx.pro.model.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserMapper userDao;

	/**
	 * 根据用户id获取用户
	 */
	@Override
	public User getObjectById(Integer id) {
		return userDao.selectByPrimaryKey(id);
	}

	/**
	 * 新增一个用户
	 */
	@Override
	public ResultMessage saveObject(UserBean usBean) {
		ResultMessage rsm = new ResultMessage();
		User user = new User();

		if (!StringUtils.isEmpty(usBean.getUserName())
				&& !StringUtils.isEmpty(usBean.getPassword())) {
			user = UserTools.copyfromUsBean(user, usBean);
			user.setAddDate(new Date());
			user.setLastModifyDate(new Date());
			user.setDeleteStatus(1);

			rsm.setStatus(userDao.insert(user));
			rsm.setMessage("新增用户成功");
		} else {
			rsm.setStatus(-1);
			rsm.setMessage("新增用户失败，用户名和密码不能为空");
		}
		return rsm;
	}

	/**
	 * 更新用户信息
	 */
	@Override
	public ResultMessage updateObject(User user) {
		ResultMessage rsm = new ResultMessage();
		
		rsm.setStatus(-1);
		if (user.getuId() != null && !StringUtils.isEmpty(user.getUserName())
				&& !StringUtils.isEmpty(user.getPassword())) {
			int res = userDao.updateByPrimaryKeySelective(user);
			if(res!=-1)
				rsm.setStatus(1);
		}
		if(rsm.getStatus()!=-1){
			rsm.setMessage("更新成功");
		}else{
			rsm.setMessage("更新失败");
		}
		return rsm;
	}

	/**
	 * 删除用户
	 */
	@Override
	public Integer deleteObject(Integer id) {
		Integer res = -1;
		if (!StringUtils.isEmpty(id))
			res = userDao.deleteByPrimaryKey(id);
		return res;
	}
	/**
	 * 查询用户
	 * 只能根据用户名、邮箱和手机查询
	 * @param userBean
	 * @return
	 */
	@Override
	public List<User> getUserByParam(UserBean userBean){
		List<User> users = new ArrayList<User>();
		User user = new User();
		if(!StringUtils.isEmpty(userBean.getEmail())){
			user.setEmail(userBean.getEmail());
		}
		if(!StringUtils.isEmpty(userBean.getUserName())){
			user.setUserName(userBean.getUserName());
		}
		if(!StringUtils.isEmpty(userBean.getPhone())){
			user.setPhone(userBean.getPhone());
		}
		users = userDao.selectByParam(user);
		return users;
	}

}
