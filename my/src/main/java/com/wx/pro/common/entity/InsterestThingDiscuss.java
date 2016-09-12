package com.wx.pro.common.entity;

/**
 * 奇闻异事讨论类
 * @author wx-simon
 *
 */
public class InsterestThingDiscuss extends BaseEntity{

    private Integer insterestThingId;//��������id

    private User userId;//������

    private Integer parentDiscussId;//�����߻ظ�����һ���˵�id���û��Ϊnull

    private String commentInfo;//����

    public Integer getInsterestThingId() {
        return insterestThingId;
    }

    public void setInsterestThingId(Integer insterestThingId) {
        this.insterestThingId = insterestThingId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Integer getParentDiscussId() {
        return parentDiscussId;
    }

    public void setParentDiscussId(Integer parentDiscussId) {
        this.parentDiscussId = parentDiscussId;
    }

    public String getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(String commentInfo) {
        this.commentInfo = commentInfo == null ? null : commentInfo.trim();
    }
}