package com.wx.pro.model.service;

import java.util.List;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.Message;
import com.wx.pro.common.entity.User;

public interface IMessageService {
	
	public ResultMessage sendMessage();
	/**
	 * 查看自己发送出的通知
	 * @param type 
	 *      0 user发出的通知
	 * 		1 user接收的信息
	 * @return
	 */
	public List<Message> getListMsgByUser(User user,int type);
	
	/**
	 * 删除通知
	 * @param id
	 * @return
	 */
	public ResultMessage delMsg(Integer id);
	
	/**
	 * 将通知状态改为已读
	 * @param msg
	 */
	public ResultMessage changeStatusToReaded(Integer msgId);
}
