package com.wx.pro.model.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.UserBean;
import com.wx.pro.common.controller.BaseController;
import com.wx.pro.common.entity.User;
import com.wx.pro.common.tools.UserTools;
import com.wx.pro.model.service.IUserService;

@Controller
@RequestMapping("UserManager")
public class UserController extends BaseController {

	@Autowired
	private IUserService userService;

	@RequestMapping("/user/search_user")
	public String searchUser(String userName, String phone, String email,
			Model model) {

		List<User> users = userService.getUserByParam(new UserBean(userName, phone,
				email));
		model.addAttribute("users", users);

		return "user/list";
	}
	@RequestMapping("/user/del")
	public void delUser(Integer userId,HttpServletResponse response){
		
		try {
			response.setContentType("text/html; charset=UTF-8");
			response.sendRedirect(homeUrl+"UserManager/user/search_user");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@RequestMapping("/user/edit")
	public String editUser(Integer userId,Model model){
		User user = new User();
		
		if(userId !=null ){
			user = userService.getObjectById(userId);
		}
		model.addAttribute("user", user);
		model.addAttribute("edit", "edit");
		
		return "user/add";
	}
	@RequestMapping("/user/save")
	public String saveUser(UserBean userBean,String edit_flag,String uId,
			Model model){
		ResultMessage rms;
		if("edit".equals(edit_flag) && !StringUtils.isEmpty(uId)){
			User user = new User();
			user = UserTools.copyfromUsBean(user, userBean);
			user.setuId(Integer.valueOf(uId));
			rms = userService.updateObject(user);
			model.addAttribute("edit", true);
		}else{
			rms = userService.saveObject(userBean);
		}
		model.addAttribute("success_url", "UserManager/user/search_user");
		return "success";
	}
}
