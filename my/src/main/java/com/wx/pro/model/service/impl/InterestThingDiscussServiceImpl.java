package com.wx.pro.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.wx.pro.common.bean.InsterestThingDiscussBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.InsterestThingDiscuss;
import com.wx.pro.common.tools.CommonTools;
import com.wx.pro.model.dao.InsterestThingDiscussMapper;
import com.wx.pro.model.service.IInterestThingDiscussService;

@Service
public class InterestThingDiscussServiceImpl implements IInterestThingDiscussService {

	@Autowired
	InsterestThingDiscussMapper insterestThingDiscussDao;

	/**
	 * 添加一条评论
	 */
	@Override
	public ResultMessage addOneDiscuss(
			InsterestThingDiscussBean insterestThDisBean) {
		ResultMessage rms = new ResultMessage();
		int res = -1;

		InsterestThingDiscuss insterestThDis = createInsterestThingDiscuss(insterestThDisBean);

		if (insterestThDis != null
				&& !StringUtils.isEmpty(insterestThDis.getCommentInfo()))
			res = insterestThingDiscussDao.insertSelective(insterestThDis);

		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}

	/**
	 * 根据奇闻异事id获取对应的评论
	 * 
	 * @param insterestThingId
	 * 
	 */
	@Override
	public List<InsterestThingDiscuss> getDiscussByInsterestThingId(
			Integer insterestThingId) {
		List<InsterestThingDiscuss> insterestThDis = new ArrayList<InsterestThingDiscuss>();
		

		if (insterestThingId != null) {
			InsterestThingDiscuss discuss = new InsterestThingDiscuss();
			discuss.setInsterestThingId(insterestThingId);
			insterestThDis = insterestThingDiscussDao.selectByParam(discuss);
		}

		return insterestThDis;
	}

	private InsterestThingDiscuss createInsterestThingDiscuss(
			InsterestThingDiscussBean insterestThDisBean) {
		InsterestThingDiscuss insterestThDis = new InsterestThingDiscuss();

		if (insterestThDisBean == null)
			return null;

		insterestThDis.setAddDate(new Date());
		insterestThDis.setCommentInfo(insterestThDisBean.getCommentInfo());
		insterestThDis.setDeleteStatus(1);
		insterestThDis.setInsterestThingId(insterestThDisBean
				.getInsterestThingId());
		insterestThDis.setLastModifyDate(new Date());
		insterestThDis.setParentDiscussId(insterestThDisBean
				.getParentDiscussId());
		insterestThDis.setUserId(insterestThDisBean.getUserId());

		return insterestThDis;
	}

}
