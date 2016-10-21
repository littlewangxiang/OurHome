package com.wx.pro.common.bean;

public class UserBean {
	
	private String userName;

    private String password;

    private String phone;

    private String email;

    private String personIntroduction;

    private String feelWord;
    
    public UserBean(){}
    
    public UserBean(String userName,String phone,String email){
    	this.userName = userName;
    	this.phone = phone;
    	this.email = email;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersonIntroduction() {
		return personIntroduction;
	}

	public void setPersonIntroduction(String personIntroduction) {
		this.personIntroduction = personIntroduction;
	}

	public String getFeelWord() {
		return feelWord;
	}

	public void setFeelWord(String feelWord) {
		this.feelWord = feelWord;
	}
    
    
}
