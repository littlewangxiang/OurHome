package com.wx.pro.common.entity;


public class HealthLife extends BaseEntity{
    
    private String lifeHealthName;

    private User userId;

    public String getLifeHealthName() {
        return lifeHealthName;
    }

    public void setLifeHealthName(String lifeHealthName) {
        this.lifeHealthName = lifeHealthName == null ? null : lifeHealthName.trim();
    }

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

}