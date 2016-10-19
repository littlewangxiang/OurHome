package com.wx.pro.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wx.pro.common.bean.LivingPaymentBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.User;
import com.wx.pro.common.tools.CommonTools;
import com.wx.pro.model.dao.LivingPaymentMapper;
import com.wx.pro.model.service.ILivingPaymentService;
/**
 * 生活付款管理类
 * 
 * @author wx
 * @date 2016-10-19
 */
@Service
public class LivingPaymentServiceImpl implements ILivingPaymentService{
	@Autowired
	private LivingPaymentMapper livePayDao;
	
	/**
	 * 发起一个生活购
	 * @return
	 */
	public ResultMessage addALivingPayment(LivingPaymentBean livePayBean ,List<User> users){
		ResultMessage rms = new ResultMessage();
		int res= -1;
		if(users!=null && users.size()>0 && livePayBean != null){
			
		}
		
		rms = CommonTools.getRmsByStatus(res);
		return rms;
	}
	
}
