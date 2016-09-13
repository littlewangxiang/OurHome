package com.wx.pro.model.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wx.pro.common.bean.MessageBean;
import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.Message;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.MessageMapper;
import com.wx.pro.model.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	@Autowired
	private MessageMapper msgDao;
	
	/**
	 * 发送通知
	 * @param MessageBean
	 */
	@Override
	public ResultMessage sendMessage(MessageBean msgBean) {
		ResultMessage rms = new ResultMessage();
		Message msg = null;

		if (msgBean != null && msgBean.getGetUser() != null
				&& msgBean.getGetUser().size() > 0) {
			List<User> listUser = msgBean.getGetUser();
			for (User user : listUser) {
				msg = new Message();
				msg.setAddDate(new Date());
				msg.setDeleteStatus(1);
				msg.setGetUser(user);
				msg.setLastModifyDate(new Date());
				msg.setMessageInfo(msgBean.getContent());
				msg.setMsgType(0);
				msg.setSendUser(msgBean.getSendUser());
				msgDao.insert(msg);
			}
			rms.setStatus(1);
			rms.setMessage("发送成功");
			return rms;
		}
		rms.setStatus(-1);
		rms.setMessage("发送失败");
		return rms;
	}

	/**
	 * 获取用户接收到的通知列表
	 * @param User
	 * @return List<Message>
	 */
	@Override
	public List<Message> getListMsgByUserId(User user) {
		List<Message> msgs = new ArrayList<Message>();
		
		if (user != null) {
			msgs = msgDao.getListMsgByUserId(user.getuId());
		}
		return msgs;
	}

	/**
	 * 删除通知
	 * 
	 * @param id
	 *            :the message you want to del
	 * @param user
	 *            : current user
	 */
	@Override
	public ResultMessage delMsg(Integer id, User user) {
		ResultMessage rms = new ResultMessage();
		Message msg = null;
		if (!StringUtils.isEmpty(id) && user != null) {
			msg = msgDao.selectByPrimaryKey(id);
			if (user.getuId() == msg.getGetUser().getuId()) {
				int res = msgDao.deleteByPrimaryKey(id);
				if (res != -1) {
					rms.setStatus(1);
					rms.setMessage("success");
					return rms;
				}
			}
		}
		rms.setStatus(-1);
		rms.setMessage("删除失败");
		return rms;
	}

	/**
	 * 将通知状态改为已读
	 */
	@Override
	public ResultMessage changeStatusToReaded(Integer msgId) {
		ResultMessage rmsg = new ResultMessage();

		if (msgId != null) {
			Message msg = msgDao.selectByPrimaryKey(msgId);
			if ("1".equals(msg.getMsgType())) {
				rmsg.setMessage("已经为已读消息");
				return rmsg;
			} else if (msg != null) {
				msg.setMsgType(1);
				msg.setLastModifyDate(new Date());
				msgDao.updateByPrimaryKeySelective(msg);
				rmsg.setStatus(1);
				rmsg.setMessage("success");
				return rmsg;
			}
		}
		rmsg.setStatus(-1);
		rmsg.setMessage("编辑状态失败");
		return rmsg;
	}

}
