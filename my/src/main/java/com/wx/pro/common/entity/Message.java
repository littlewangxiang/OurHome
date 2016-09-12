package com.wx.pro.common.entity;


public class Message extends BaseEntity{

    private String messageInfo;

    private Integer msgType;

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
}