package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.LivingPaymentBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.bean.ShareInfoBean;

public interface ILivingPaymentService {
	
	public ResultMessage addALivingPayment(LivingPaymentBean livePayBean ,List<ShareInfoBean> shareInfoBean);
}
