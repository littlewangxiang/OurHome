package com.wx.pro.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.SpecificationBean;
import com.wx.pro.common.entity.Specification;
import com.wx.pro.model.dao.SpecificationMapper;
import com.wx.pro.model.service.ISpecificationService;

@Service
public class SpecificationServiceImpl implements ISpecificationService {

	@Autowired
	private SpecificationMapper specDao;

	/**
	 * 获取所有的缴费项目
	 */
	@Override
	public List<Specification> getAllSpec() {
		List<Specification> allSpec = specDao.getAllSpec();
		return allSpec;
	}
	
	/**
	 * 获取某一个缴费项目
	 */
	@Override
	public Specification getSpecById(Integer id) {
		Specification spec = null;
		if (id != null) {
			spec = specDao.selectByPrimaryKey(id);
		}
		return spec;
	}
	
	/**
	 * 添加一条缴费项目
	 */
	@Override
	public ResultMessage addSpec(SpecificationBean specBean) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 更新一条缴费项目
	 */
	@Override
	public ResultMessage updateSpec(Specification spec) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 删除一条缴费项目
	 */
	@Override
	public ResultMessage delSpec(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
