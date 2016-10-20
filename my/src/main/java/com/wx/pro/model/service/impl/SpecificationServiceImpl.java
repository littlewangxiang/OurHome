package com.wx.pro.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public Specification addSpec(SpecificationBean specBean) {
		// TODO Auto-generated method stub
		Specification record = createSpec(specBean);
		specDao.insertSelective(record);
		return record;
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

	private Specification createSpec(SpecificationBean specBean){
		Specification spec = new Specification();
		
		if(specBean == null) return spec;
		spec.setAddDate(new Date());
		spec.setDeleteStatus(1);
		spec.setLastModifyDate(new Date());
		spec.setName(specBean.getName());
		
		return spec;
	}
}
