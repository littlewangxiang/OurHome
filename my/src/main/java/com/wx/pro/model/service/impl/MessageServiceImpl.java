package com.wx.pro.model.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.wx.pro.common.bean.ResultMessage;
import com.wx.pro.common.entity.Message;
import com.wx.pro.common.entity.User;
import com.wx.pro.model.dao.MessageMapper;
import com.wx.pro.model.service.IMessageService;

@Service
public class MessageServiceImpl implements IMessageService {
	@Autowired
	private MessageMapper msgDao;

	@Override
	public ResultMessage sendMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getListMsgByUser(User user, int type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage delMsg(Integer id) {
		ResultMessage rms = new ResultMessage();
		
		if (!StringUtils.isEmpty(id)) {
			int res = msgDao.deleteByPrimaryKey(id);
			if (res != -1) {
				rms.setStatus(1);
				rms.setMessage("success");
				return rms;
			}
		}
		rms.setStatus(-1);
		rms.setMessage("删除失败");
		return rms;
	}

	@Override
	public ResultMessage changeStatusToReaded(Integer msgId) {
		ResultMessage rmsg = new ResultMessage();
		
		if (msgId != null) {
			Message msg = msgDao.selectByPrimaryKey(msgId);
			if("1".equals(msg.getMsgType())){
				rmsg.setMessage("已经为已读消息");
			}else if(msg!=null){
				msg.setMsgType(1);
				msg.setLastModifyDate(new Date());
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
