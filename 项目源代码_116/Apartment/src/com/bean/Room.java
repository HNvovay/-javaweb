package com.bean;

public class Room {
	private String  roomID;
	private String roomStyle;
	private String roomStroey;
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getRoomStyle() {
		return roomStyle;
	}
	public void setRoomStyle(String roomStyle) {
		this.roomStyle = roomStyle;
	}
	public String getRoomStroey() {
		return roomStroey;
	}
	public void setRoomStroey(String roomStroey) {
		this.roomStroey = roomStroey;
	}
	public Room(String roomID, String roomStyle, String roomStroey) {
		super();
		this.roomID = roomID;
		this.roomStyle = roomStyle;
		this.roomStroey = roomStroey;
	}
	public Room(String roomID) {
		super();
		this.roomID = roomID;
	}
	
}
