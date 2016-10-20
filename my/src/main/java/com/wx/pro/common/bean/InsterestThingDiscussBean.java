package com.wx.pro.common.bean;

import com.wx.pro.common.entity.User;

public class InsterestThingDiscussBean {
	
	private Integer insterestThingId;//奇闻趣事id

    private User userId;//评论者信息

    private Integer parentDiscussId;//评论的父节点id没有则为空

    private String commentInfo;//评论信息

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
		this.commentInfo = commentInfo;
	}
}
