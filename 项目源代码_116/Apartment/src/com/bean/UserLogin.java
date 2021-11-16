package com.bean;

public class UserLogin {
	private String userName;
	private String userPassword;
	private String userNumber;
	private String userWechat;
	private String userBirthday;
	private String userEmail;
	private String userRoom;

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public UserLogin(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public UserLogin() {
		// TODO Auto-generated constructor stub
	}
	
	public UserLogin(String userName, String userPassword,String userNumber) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNumber=userNumber;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserWechat() {
		return userWechat;
	}
	public void setUserWechat(String userWechat) {
		this.userWechat = userWechat;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserRoom() {
		return userRoom;
	}
	public void setUserRoom(String userRoom) {
		this.userRoom = userRoom;
	}
	
	public void clear() {
		this.setUserBirthday(null);
		this.setUserEmail(null);
		this.setUserName(null);
		this.setUserPassword(null);
		this.setUserRoom(null);
		this.setUserWechat(null);
		this.setUserNumber(null);
	}
}
