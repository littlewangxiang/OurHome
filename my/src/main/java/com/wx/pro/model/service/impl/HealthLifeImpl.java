package com.wx.pro.model.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.wx.pro.common.bean.HealthLifeBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.HealthLife;
import com.wx.pro.model.dao.HealthLifeMapper;
import com.wx.pro.model.service.IHealthLife;

/**
 * 健康生活管理类
 * 
 * @author wx-simon
 */
@Service
public class HealthLifeImpl implements IHealthLife {
	@Autowired
	private HealthLifeMapper healthLifeDao;

	@Override
	public HealthLife getObjectById(Integer id) {
		// TODO Auto-generated method stub
		return healthLifeDao.selectByPrimaryKey(id);
	}

	@Override
	public Integer saveObject(HealthLife healthLife) {
		// TODO Auto-generated method stub
		int res = -1;
		if (healthLife.getLifeHealthName() != null
				&& healthLife.getUserId() != null) {
			healthLife.setAddDate(new Date());
			healthLife.setLastModifyDate(new Date());

			if (healthLife.getuId() == null) {
				res = healthLifeDao.insert(healthLife);
			} else {
				res = healthLifeDao.updateByPrimaryKey(healthLife);
			}
		}
		return res;
	}

	@Override
	public Integer updateObject(HealthLife healthLife) {
		// TODO Auto-generated method stub
		return saveObject(healthLife);
	}

	@Override
	public Integer deleteObject(Integer id) {
		// TODO Auto-generated method stub
		int res = -1;
		if (id != null) {
			res = healthLifeDao.deleteByPrimaryKey(id);
		}
		return res;
	}

	/**
	 * 添加一条健康生活记录
	 * 
	 * @return
	 */
	public ResultMessage addHealthLife(HealthLifeBean healthBean) {
		ResultMessage rsm = new ResultMessage();
		HealthLife health = null;
		if (!StringUtils.isEmpty(healthBean.getLifeHealthName())
				&& healthBean.getUserId() != null) {
			health = new HealthLife();
			health.setAddDate(new Date());
			health.setLastModifyDate(new Date());
			health.setLifeHealthName(healthBean.getLifeHealthName());
			health.setUserId(healthBean.getUserId());

			healthLifeDao.insert(health);

		} else {
			rsm.setStatus(-1);
			rsm.setMessage("HealthName不能为空UserId不能为空");
		}
		return rsm;
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	public ResultMessage editHealthLife(HealthLife health) {
		ResultMessage rsm = new ResultMessage();
		if (health.getuId() != null
				&& !StringUtils.isEmpty(health.getLifeHealthName())) {
			health.setLastModifyDate(new Date());
			healthLifeDao.updateByPrimaryKey(health);
			rsm.setMessage("success");
			rsm.setStatus(1);
		} else {
			rsm.setStatus(-1);
			rsm.setMessage("更新失败");
		}
		return rsm;
	}

	/*
	 * 删除
	 */
	public ResultMessage delHealthLife(Integer id) {
		ResultMessage rsm = new ResultMessage();
		if (id != null) {
			healthLifeDao.deleteByPrimaryKey(id);
			rsm.setStatus(1);
			rsm.setMessage("success");
		}else{
			rsm.setStatus(-1);
			rsm.setMessage("删除失败");
		}
		return rsm;
	}
}
