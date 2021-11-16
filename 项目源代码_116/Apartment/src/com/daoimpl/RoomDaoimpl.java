package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Room;
import com.dao.RoomDao;
import com.util.ConnectDB;

public class RoomDaoimpl implements RoomDao{

	@Override
	public boolean addRoom(Room room) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="insert into room(roomID,roomStyle,roomStroey) values (?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, room.getRoomID());
			pstmt.setString(2, room.getRoomStyle());
			pstmt.setString(3, room.getRoomStroey());
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRoom(Room room) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="update room set roomStyle=?,roomStroey=? where roomID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, room.getRoomStyle());
			pstmt.setString(2, room.getRoomStroey());
			pstmt.setString(3, room.getRoomID());
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRoom(Room room) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="DELETE FROM room WHERE roomID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, room.getRoomID());
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet selectRoom(String room) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from room where roomID like ? or roomStyle like ? or roomStroey like ?";
		String check1="%"+room+"%";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, check1);
			pstmt.setString(2, check1);
			pstmt.setString(3, check1);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String getroomStyle(String roomID) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from roomstyle where id=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, roomID);
			ResultSet resultStyle=pstmt.executeQuery();
			if(resultStyle.next()) {
				return resultStyle.getString("roomStyle");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getRoomCharge(String roomID) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from room,roomstyle where room.roomStyle=roomstyle.id AND roomID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, roomID);
			ResultSet resultStyle=pstmt.executeQuery();
			if(resultStyle.next()) {
				return resultStyle.getInt("roomCharge");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public float getRoomeleCharge() {
		// TODO Auto-generated method stub
		float eleCharge = 0;
		Connection  conn1=new ConnectDB().getConn();
      	String sql1="select * from elewaterCharge";
      	PreparedStatement pstmt1;
		try {
			pstmt1 = conn1.prepareStatement(sql1);
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next()) {
				eleCharge= rs1.getFloat("eleCharge");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	return eleCharge;
	}

	@Override
	public float getRoomwaterCharge() {
		float waterCharge = 0;
		Connection  conn1=new ConnectDB().getConn();
      	String sql1="select * from elewaterCharge";
      	PreparedStatement pstmt1;
		try {
			pstmt1 = conn1.prepareStatement(sql1);
			ResultSet rs1=pstmt1.executeQuery();
			if(rs1.next()) {
				waterCharge= rs1.getFloat("waterCharge");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      	return waterCharge;
	}

}
