package com.wx.pro.common.entity;


public class InsterestThing extends BaseEntity{
    
    private User publishUserId;

    private String info;

    public User getPublishUserId() {
        return publishUserId;
    }

    public void setPublishUserId(User publishUserId) {
        this.publishUserId = publishUserId;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }
}