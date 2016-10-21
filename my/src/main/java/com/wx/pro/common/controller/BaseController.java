package com.wx.pro.common.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.wx.pro.common.entity.User;


public class BaseController {
	
	protected static final Logger log = LoggerFactory.getLogger(User.class);
	@Value("#{configProperties['web_path']}")
    protected String homeUrl;
	@Value("#{configProperties['js_path']}")
	private String jsUrl;
	@Value("#{configProperties['img_path']}")
	private String imgPath;
	@Value("#{configProperties['cssPath']}")
	private String cssPath;
	
	@ModelAttribute
	public void set(Model model){
		model.addAttribute("basePath", homeUrl);
		model.addAttribute("jsPath", jsUrl);
		model.addAttribute("imgPath", imgPath);
		model.addAttribute("cssPath",cssPath);
	}
}
