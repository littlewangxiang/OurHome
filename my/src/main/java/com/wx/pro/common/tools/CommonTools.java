package com.wx.pro.common.tools;

import com.wx.pro.common.bean.ResultMessage;

public class CommonTools {
	/**
	 * 通过结果状态获取resultMessage
	 * 
	 * @param res -1失败
	 * @return
	 */
	public static ResultMessage getRmsByStatus(int res){
		ResultMessage rms = new ResultMessage();
		if(res==-1){
			rms.setStatus(-1);
			rms.setMessage("faild");
		}else{
			rms.setStatus(res);
			rms.setMessage("success");
		}
		return rms;
	}
}
