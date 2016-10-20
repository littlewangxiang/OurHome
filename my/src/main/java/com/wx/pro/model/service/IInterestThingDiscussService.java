package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.InsterestThingDiscussBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.InsterestThingDiscuss;

public interface IInterestThingDiscussService {
	
	public ResultMessage addOneDiscuss(InsterestThingDiscussBean insterestThDisBean);
	
	public List<InsterestThingDiscuss> getDiscussByInsterestThingId(Integer insterestThingId);
}
