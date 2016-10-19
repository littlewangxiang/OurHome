package com.wx.pro.common.entity;

/**
 * 生活缴费类
 * @author Administrator
 *
 */
public class LivingPayment extends BaseEntity{

    private User userId;

    private String name;

    private Specification specId;//缴费项目

    private String shareInfo;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }


    public String getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(String shareInfo) {
        this.shareInfo = shareInfo == null ? null : shareInfo.trim();
    }

	public Specification getSpecId() {
		return specId;
	}

	public void setSpecId(Specification specId) {
		this.specId = specId;
	}
}