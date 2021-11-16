package com.dao;

import java.sql.ResultSet;

import com.bean.Room;


public interface RoomDao {
	public boolean addRoom(Room room);
	public boolean updateRoom(Room room);
	public boolean deleteRoom(Room room);  
	public ResultSet selectRoom(String room);
	public String getroomStyle(String roomID);
	public int getRoomCharge(String roomID);
	public float getRoomeleCharge();
	public float getRoomwaterCharge();
}
