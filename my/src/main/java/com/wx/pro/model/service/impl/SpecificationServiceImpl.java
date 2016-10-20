package com.wx.pro.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.SpecificationBean;
import com.wx.pro.common.entity.Specification;
import com.wx.pro.common.tools.CommonTools;
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
	 * 
	 * @param specBean 参数
	 * @param id 要更新的数据的id
	 */
	@Override
	@Transactional
	public ResultMessage updateSpec(SpecificationBean specBean, Integer id) {
		ResultMessage rms = new ResultMessage();
		int res = -1;
		Specification spec = createSpec(specBean);
		spec.setuId(id);
		res = specDao.updateByPrimaryKeySelective(spec);
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}
	
	/**
	 * 删除一条缴费项目
	 */
	@Override
	@Transactional
	public ResultMessage delSpec(Integer id) {
		ResultMessage rms = new ResultMessage();
		int res =-1;
		res = specDao.deleteByPrimaryKey(id);
		rms = CommonTools.getRmsByStatus(res);
		return rms;
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
