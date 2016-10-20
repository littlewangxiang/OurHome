package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.SpecificationBean;
import com.wx.pro.common.entity.Specification;

public interface ISpecificationService {
	
	public List<Specification> getAllSpec();
	
	public Specification getSpecById(Integer id);
	
	public Specification addSpec(SpecificationBean specBean);
	
	public ResultMessage updateSpec(SpecificationBean specBean, Integer id);
	
	public ResultMessage delSpec(Integer id);
}
