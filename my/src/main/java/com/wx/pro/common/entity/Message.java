package com.wx.pro.common.entity;


public class Message extends BaseEntity{

    private String messageInfo;

    private Integer msgType;//状态0未读、1已读
    
    private User sendUserId;//发送人
    
    private User getUserId;//接收人

    public String getMessageInfo() {
        return messageInfo;
    }

    public void setMessageInfo(String messageInfo) {
        this.messageInfo = messageInfo == null ? null : messageInfo.trim();
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

	public User getSendUser() {
		return sendUserId;
	}

	public void setSendUser(User sendUserId) {
		this.sendUserId = sendUserId;
	}

	public User getGetUser() {
		return getUserId;
	}

	public void setGetUser(User getUserId) {
		this.getUserId = getUserId;
	}
}