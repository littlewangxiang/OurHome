package com.wx.pro.model.service;

import com.wx.pro.common.bean.HealthLifeBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.HealthLife;

public interface IHealthLife {
	
	public HealthLife getObjectById(Integer id);
	
	public Integer saveObject(HealthLife obj);
	
	public Integer updateObject(HealthLife obj);
	
	public Integer deleteObject(Integer id);
	
	public ResultMessage addHealthLife(HealthLifeBean healthBean);
	
	public ResultMessage editHealthLife(HealthLife health);
	
	public ResultMessage delHealthLife(Integer id);
}
