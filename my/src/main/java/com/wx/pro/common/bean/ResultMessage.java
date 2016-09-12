package com.wx.pro.common.bean;

public class ResultMessage {
	private int status;//-1失败
	
	private String message;//失败或成功说明

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
