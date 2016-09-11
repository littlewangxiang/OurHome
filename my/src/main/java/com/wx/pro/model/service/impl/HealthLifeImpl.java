package com.wx.pro.model.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.wx.pro.common.bean.HealthLifeBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.HealthLife;
import com.wx.pro.model.dao.HealthLifeMapper;
import com.wx.pro.model.dao.UserMapper;
import com.wx.pro.model.service.IHealthLife;

/**
 * 健康生活管理服务
 * 
 * @author wx-simon
 */
@Service("healthLifeService")
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
				&& healthBean.getUserId()!=null) {
			health = new HealthLife();
			health.setAddDate(new Date());
			health.setLastModifyDate(new Date());
			health.setLifeHealthName(healthBean.getLifeHealthName());
			health.setUserId(healthBean.getUserId());
			
			healthLifeDao.insert(health);

		}else{
			rsm.setStatus(0);
			rsm.setMessage("HealthName或者UserId不能为空");
		}
		return null;
	}

}
