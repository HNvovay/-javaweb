package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Contract;
import com.dao.ContractDao;
import com.util.ConnectClose;
import com.util.ConnectDB;

public class ContractDaoimpl implements ContractDao {

	@Override
	public boolean addContract(Contract contract) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		PreparedStatement pstmt;
		String sql="insert into renting(roomID,residentID,contractImg,isCost,eleDegree,waterDegree) values (?,?,?,?,?,?)";
		try {
			String contractImgname="images/contract/"+contract.getContractImg();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, contract.getRoomID());
			pstmt.setString(2, contract.getResidentID());
			pstmt.setString(3, contractImgname);
			pstmt.setString(4, "未付款");
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
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
	public boolean updateContract(Contract contract) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContract(Contract contract) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="DELETE FROM renting WHERE roomID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, contract.getRoomID());
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
	public ResultSet selectContract(String check) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from renting where roomID like ? or residentID like ?";
		String check1="%"+check+"%";
		ResultSet rs = null;
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, check1);
			pstmt.setString(2, check1);
			rs=pstmt.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public String getContractImg(String roomID) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="select * from renting where roomID=?";
		String contractImg=null;
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, roomID);
			ResultSet rs=pstmt.executeQuery();
			contractImg=rs.getString("contractImg");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return contractImg;
	}

}
