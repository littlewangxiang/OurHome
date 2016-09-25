package com.wx.pro.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.pro.common.bean.InsterestThingBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.InsterestThing;
import com.wx.pro.common.tools.CommonTools;
import com.wx.pro.model.dao.InsterestThingMapper;
import com.wx.pro.model.service.IIterestThing;

@Service
public class IterestThingImpl implements IIterestThing {

	@Autowired
	InsterestThingMapper insteresThDao;
	
	/**
	 * 获取所有的奇闻异事
	 */
	@Override
	public List<InsterestThing> getAllInsterestThingsList() {
		List<InsterestThing> allInsterestThs= insteresThDao.selectAll();
		return allInsterestThs;
	}

	/**
	 * 根据id查询奇闻异事
	 */
	@Override
	public InsterestThing getInsterestThingById(Integer id) {
		InsterestThing insteresTh = null;

		if (id != null) {
			insteresTh = insteresThDao.selectByPrimaryKey(id);
		}
		return insteresTh;
	}

	/**
	 * 添加一条奇闻异事
	 */
	@Override
	public ResultMessage addInsterestThing(InsterestThingBean insterestThingBean) {
		ResultMessage rms = new ResultMessage();
		InsterestThing insterestTh = new InsterestThing();
		int res = -1;

		insterestTh = copyFromInsterestThingBean(insterestTh,
				insterestThingBean);
		if (insterestTh.getPublishUserId() != null) {
			insterestTh.setAddDate(new Date());
			insterestTh.setDeleteStatus(1);
			insterestTh.setLastModifyDate(new Date());
			res = insteresThDao.insertSelective(insterestTh);
		}
		rms = CommonTools.getRmsByStatus(res);

		return rms;
	}

	/**
	 * 编辑奇闻异事
	 */
	@Override
	public ResultMessage editInsterestThing(InsterestThing insterestThing) {
		ResultMessage rms = new ResultMessage();
		int res = -1;
		
		if (insterestThing != null && insterestThing.getuId()!=null) {
			res = insteresThDao.updateByPrimaryKeySelective(insterestThing);
		}
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}

	/**
	 * 删除奇闻异事
	 */
	@Override
	public ResultMessage delInsterestThing(Integer id) {
		ResultMessage rms = new ResultMessage();
		int res = -1;
		if (id != null) {
			res = insteresThDao.deleteByPrimaryKey(id);
		}
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}

	private InsterestThing copyFromInsterestThingBean(InsterestThing inst,
			InsterestThingBean instBean) {
		inst.setPublishUserId(instBean.getPublishUserId());
		inst.setInfo(instBean.getInfo());
		return inst;
	}

}
