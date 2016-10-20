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

import com.alibaba.fastjson.JSON;
import com.wx.pro.common.bean.LivingPaymentBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.ShareInfoBean;
import com.wx.pro.common.bean.SpecificationBean;
import com.wx.pro.common.entity.LivingPayment;
import com.wx.pro.common.entity.Specification;
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
	 * 根据条件查询生活付 （目前只支持 根据发起者、根据生活减肥名称查询）
	 * 
	 * @return
	 */
	@Override
	public List<LivingPayment> getLivingPayment(
			LivingPaymentBean livingPaymentBean) {
		List<LivingPayment> livePays = new ArrayList<LivingPayment>();
		LivingPayment record = new LivingPayment();
		if (!StringUtils.isEmpty(livingPaymentBean.getName())) {
			record.setName(livingPaymentBean.getName());
		}
		if (livingPaymentBean.getUser() != null) {
			record.setUserId(livingPaymentBean.getUser());
		}

		livePays = livePayDao.selectByParam(record);

		return livePays;
	}

	/**
	 * 删除一条生活付
	 * 
	 * @param id
	 * @return
	 */
	@Override
	@Transactional
	public ResultMessage delLivingPayment(Integer id) {
		ResultMessage rms = new ResultMessage();
		int res = -1;

		if (id != null) {
			LivingPayment livePayment = livePayDao.selectByPrimaryKey(id);

			specService.delSpec(livePayment.getSpecId().getuId());

			res = livePayDao.deleteByPrimaryKey(id);
		}
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}

	/**
	 * 更新生活付
	 * 
	 */
	@Override
	public ResultMessage updateLivingPaymet(LivingPayment livepay) {
		ResultMessage rms = new ResultMessage();
		int res = -1;

		if (livepay != null && livepay.getuId() != null) {
			res = livePayDao.updateByPrimaryKeySelective(livepay);
		}
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}

	@Override
	public LivingPayment getLivingPaymentById(Integer id) {
		LivingPayment livePay = null;

		if (id != null) {
			livePay = livePayDao.selectByPrimaryKey(id);
		}

		return livePay;
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
