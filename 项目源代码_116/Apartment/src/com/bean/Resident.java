package com.bean;

public class Resident {
	private String residentID;
	private String residentName;
	private String residentAge;
	private String residentNumber;
	private String residentProfession;
	private String remarks;
	private String residentIDCardNum;
	
	public Resident(String residentID) {
		super();
		this.residentID = residentID;
	}
	public String getResidentID() {
		return residentID;
	}
	public void setResidentID(String residentID) {
		this.residentID = residentID;
	}
	public String getResidentName() {
		return residentName;
	}
	public void setResidentName(String residentName) {
		this.residentName = residentName;
	}
	public String getResidentAge() {
		return residentAge;
	}
	public void setResidentAge(String residentAge) {
		this.residentAge = residentAge;
	}
	public String getResidentNumber() {
		return residentNumber;
	}
	public void setResidentNumber(String residentNumber) {
		this.residentNumber = residentNumber;
	}
	public String getResidentProfession() {
		return residentProfession;
	}
	public void setResidentProfession(String residentProfession) {
		this.residentProfession = residentProfession;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getResidentIDCardNum() {
		return residentIDCardNum;
	}
	public void setResidentIDCardNum(String residentIDCardNum) {
		this.residentIDCardNum = residentIDCardNum;
	}
	public Resident(String residentID, String residentName, String residentAge, String residentNumber,
			String residentProfession, String remarks, String residentIDCardNum) {
		super();
		this.residentID = residentID;
		this.residentName = residentName;
		this.residentAge = residentAge;
		this.residentNumber = residentNumber;
		this.residentProfession = residentProfession;
		this.remarks = remarks;
		this.residentIDCardNum = residentIDCardNum;
	}
}
