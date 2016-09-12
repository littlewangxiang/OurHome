package com.wx.pro.common.entity;

/**
 * 生活缴费类
 * @author Administrator
 *
 */
public class LivingPayment extends BaseEntity{

    private User userId;

    private String name;

    private Integer specId;

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

    public Integer getSpecId() {
        return specId;
    }

    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    public String getShareInfo() {
        return shareInfo;
    }

    public void setShareInfo(String shareInfo) {
        this.shareInfo = shareInfo == null ? null : shareInfo.trim();
    }
}