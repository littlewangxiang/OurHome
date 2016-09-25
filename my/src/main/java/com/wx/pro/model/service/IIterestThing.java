package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.InsterestThingBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.InsterestThing;

public interface IIterestThing {
	
	public List<InsterestThing> getAllInsterestThingsList();
	
	public InsterestThing getInsterestThingById(Integer id);
	
	public ResultMessage addInsterestThing(InsterestThingBean insterestThingBean);
	
	public ResultMessage editInsterestThing(InsterestThing insterestThing);
	
	public ResultMessage delInsterestThing(Integer id);
	
}
