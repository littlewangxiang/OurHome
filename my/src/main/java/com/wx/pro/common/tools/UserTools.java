package com.wx.pro.common.tools;

import com.wx.pro.common.bean.UserBean;
import com.wx.pro.common.entity.User;

public class UserTools {

	public static User copyfromUsBean(User user, UserBean usBean) {
		if (user != null && usBean != null) {
			user.setEmail(usBean.getEmail());
			user.setFeelWord(usBean.getFeelWord());
			user.setPassword(usBean.getPassword());
			user.setPersonIntroduction(usBean.getPersonIntroduction());
			user.setPhone(usBean.getPhone());
			user.setUserName(usBean.getUserName());
		}
		return user;
	}
}
