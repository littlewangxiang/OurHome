package com.wx.pro.common.entity;

import java.util.Date;

/**
 * 
 * 所有表的基类
 * @author Administrator
 */
public class BaseEntity {
	
	private Integer uId;

    private Date addDate;

    private Date lastModifyDate;

    private Integer deleteStatus;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Date getLastModifyDate() {
		return lastModifyDate;
	}

	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}

	public Integer getDeleteStatus() {
		return deleteStatus;
	}

	public void setDeleteStatus(Integer deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
}
