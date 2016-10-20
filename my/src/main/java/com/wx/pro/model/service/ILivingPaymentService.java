package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.LivingPaymentBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.ShareInfoBean;
import com.wx.pro.common.entity.LivingPayment;

public interface ILivingPaymentService {

	public ResultMessage addALivingPayment(LivingPaymentBean livePayBean,
			List<ShareInfoBean> shareInfoBean);

	public List<LivingPayment> getLivingPayment(
			LivingPaymentBean livingPaymentBean);
	
	public ResultMessage delLivingPayment(Integer id);
	
	public ResultMessage updateLivingPaymet(LivingPayment livepay);
	
	public LivingPayment getLivingPaymentById(Integer id);
}
