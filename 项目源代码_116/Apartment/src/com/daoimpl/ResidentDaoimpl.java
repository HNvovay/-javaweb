package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bean.Resident;
import com.dao.ResidentDao;
import com.util.ConnectDB;

public class ResidentDaoimpl implements ResidentDao{
	
	
	@Override
	public boolean addResident(Resident resident) {
		// TODO Auto-generated method stub
		Date d=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String now = df.format(d);
		Connection conn=new ConnectDB().getConn();
		String sql="insert into resident(residentID,residentName,residentAge,residentNumber,residentProfession,residentIDCardNum,remarks,time) values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, resident.getResidentID());
			pstmt.setString(2, resident.getResidentName());
			pstmt.setString(3, resident.getResidentAge());
			pstmt.setString(4, resident.getResidentNumber());
			pstmt.setString(5, resident.getResidentProfession());
			pstmt.setString(6, resident.getResidentIDCardNum());
			pstmt.setString(7, resident.getRemarks());	
			pstmt.setString(8, now);
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
	public boolean updateResident(Resident resident) {
		// TODO Auto-generated method stub
		
		Connection conn=new ConnectDB().getConn();
		String sql="update resident set residentName=?,residentAge=?,residentNumber=?,residentProfession=?,residentIDCardNum=?,remarks=? where residentID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, resident.getResidentName());
			pstmt.setString(2, resident.getResidentAge());
			pstmt.setString(3, resident.getResidentNumber());
			pstmt.setString(4, resident.getResidentProfession());
			pstmt.setString(5, resident.getResidentIDCardNum());
			pstmt.setString(6, resident.getRemarks());
			pstmt.setString(7, resident.getResidentID());
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
	public boolean deleteResident(Resident resident) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="DELETE FROM resident WHERE residentID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, resident.getResidentID());
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
	public ResultSet selectResident(String check) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from resident where residentID like ? or residentName like ? order by residentID+0";
		String check1="%"+check+"%";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, check1);
			pstmt.setString(2, check1);
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String getResidentName(String residentID) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from resident where residentID=? ";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, residentID);
			ResultSet resultStyle=pstmt.executeQuery();
			if(resultStyle.next()) {
				return resultStyle.getString("residentName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
