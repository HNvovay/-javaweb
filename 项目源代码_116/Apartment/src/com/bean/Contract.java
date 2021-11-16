package com.bean;

public class Contract {
	private String roomID;
	private String residentID;
	private String contractImg;
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getResidentID() {
		return residentID;
	}
	public void setResidentID(String residentID) {
		this.residentID = residentID;
	}
	public String getContractImg() {
		return contractImg;
	}
	public void setContractImg(String contractImg) {
		this.contractImg = contractImg;
	}
	public Contract(String roomID, String residentID, String contractImg) {
		super();
		this.roomID = roomID;
		this.residentID = residentID;
		this.contractImg = contractImg;
	}
	public Contract(String roomID) {
		super();
		this.roomID = roomID;
	}	  
	 

}
