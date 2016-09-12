package com.wx.pro.common.entity;

/**
 * 
 * @author wx-simon
 *
 */
public class InsterestThingDiscuss extends BaseEntity{

    private Integer insterestThingId;//奇闻异事id

    private User userId;//评论者

    private Integer parentDiscussId;//评论者回复的上一个人的id如果没有为null

    private String commentInfo;//评论

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