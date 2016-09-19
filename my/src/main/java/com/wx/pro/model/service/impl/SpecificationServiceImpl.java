package com.wx.pro.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
		ResultMessage rms = new ResultMessage();
		Specification spec = null;

		if (specBean != null && !StringUtils.isEmpty(specBean.getName())) {
			spec = new Specification();
			spec.setAddDate(new Date());
			spec.setDeleteStatus(1);
			spec.setLastModifyDate(new Date());
			spec.setName(specBean.getName());
			specDao.insertSelective(spec);
			rms.setStatus(1);
			rms.setMessage("添加成功");
		} else {
			rms.setStatus(-1);
			rms.setMessage("添加失败");
		}
		return rms;
	}

	/**
	 * 更新一条缴费项目
	 */
	@Override
	public ResultMessage updateSpec(Specification spec) {
		ResultMessage rms = new ResultMessage();

		if (spec != null && spec.getuId() != null) {
			specDao.updateByPrimaryKeySelective(spec);
			rms.setStatus(1);
			rms.setMessage("更新成功");
		} else {
			rms.setStatus(-1);
			rms.setMessage("更新失败");
		}
		return rms;
	}

	/**
	 * 删除一条缴费项目
	 */
	@Override
	public ResultMessage delSpec(Integer id) {
		ResultMessage rms = new ResultMessage();

		int res = -1;
		if (id != null)
			res = specDao.deleteByPrimaryKey(id);
		if (res != -1) {
			rms.setStatus(1);
			rms.setMessage("删除成功");
		}else{
			rms.setStatus(-1);
			rms.setMessage("删除失败");
		}

		return rms;
	}

}
