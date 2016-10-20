package com.wx.pro.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import sun.rmi.log.ReliableLog;

import com.alibaba.fastjson.JSON;
import com.wx.pro.common.bean.LivingPaymentBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.ShareInfoBean;
import com.wx.pro.common.bean.SpecificationBean;
import com.wx.pro.common.entity.LivingPayment;
import com.wx.pro.common.entity.Specification;
import com.wx.pro.common.entity.User;
import com.wx.pro.common.tools.CommonTools;
import com.wx.pro.model.dao.LivingPaymentMapper;
import com.wx.pro.model.service.ILivingPaymentService;
import com.wx.pro.model.service.ISpecificationService;

/**
 * 生活付款管理类
 * 
 * @author wx
 * @date 2016-10-19
 */
@Service
public class LivingPaymentServiceImpl implements ILivingPaymentService {
	@Autowired
	private LivingPaymentMapper livePayDao;
	@Autowired
	private ISpecificationService specService;

	/**
	 * 发起一个生活购
	 * 
	 * @param livePayBean
	 *            生活付参数bean
	 * @param users
	 *            分摊的用户
	 * @return ResultMessage
	 */
	@Override
	@Transactional
	public ResultMessage addALivingPayment(LivingPaymentBean livePayBean,
			List<ShareInfoBean> shareInfoBean) {
		ResultMessage rms = new ResultMessage();
		int res = -1;

		LivingPayment livePay = createLivingPayment(livePayBean, shareInfoBean);

		if (livePay != null) {
			res = livePayDao.insertSelective(livePay);
		}
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}

	/**
	 * 将livePayBean转化为LivingPayment实体
	 * 
	 * @param livePayBean
	 * @param shareInfoBean
	 * @return
	 */
	@Transactional
	private LivingPayment createLivingPayment(LivingPaymentBean livePayBean,
			List<ShareInfoBean> shareInfoBean) {
		LivingPayment resLivingPayment = new LivingPayment();
		List<Map> shareMap = new ArrayList<Map>();

		if (shareInfoBean == null || shareInfoBean.size() <= 0
				|| livePayBean == null
				|| StringUtils.isEmpty(livePayBean.getSpecName())) {
			return resLivingPayment;
		}
		for (ShareInfoBean shareInfo : shareInfoBean) {
			Map<String, Object> temp = new HashMap<String, Object>();
			temp.put("user_id", shareInfo.getUserId());
			temp.put("user_name", shareInfo.getUserName());
			temp.put("share_status", 0);
			temp.put("share_time", new Date());
			shareMap.add(temp);
		}
		resLivingPayment.setShareInfo(JSON.toJSONString(shareMap));
		// 创建一条缴费项目
		SpecificationBean specBean = new SpecificationBean();
		specBean.setName(livePayBean.getSpecName());
		Specification sepc = specService.addSpec(specBean);

		resLivingPayment.setSpecId(sepc);
		
		resLivingPayment.setName(livePayBean.getName());
		resLivingPayment.setUserId(livePayBean.getUser());
		resLivingPayment.setAddDate(new Date());
		resLivingPayment.setDeleteStatus(1);
		resLivingPayment.setLastModifyDate(new Date());

		return resLivingPayment;
	}
}
