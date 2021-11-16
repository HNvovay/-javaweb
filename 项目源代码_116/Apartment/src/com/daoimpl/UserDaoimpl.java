package com.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.UserLogin;
import com.dao.UserDao;
import com.util.ConnectDB;

public class UserDaoimpl implements UserDao {

	@Override
	public int login(UserLogin userlogin) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql = "select * from Login where userName=? and userPassword=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userlogin.getUserName());
			pstmt.setString(2, userlogin.getUserPassword());
			ResultSet result = pstmt.executeQuery();
			if(result.next()) {
				return 1;
			}else {
				return -1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}
	}

	@Override
	public UserLogin Loginsucceedtakeuser(UserLogin userlogin) {
		// TODO Auto-generated method stub
		String userName=userlogin.getUserName();
		Connection conn=new ConnectDB().getConn();
		String sql = "select * from Login where userName=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			ResultSet result = pstmt.executeQuery();
			if(result.next()){
				userlogin.setUserPassword(result.getString("userPassword"));
				userlogin.setUserNumber(result.getString("userNumber"));
				userlogin.setUserBirthday(result.getString("userBirthday"));
				userlogin.setUserEmail(result.getString("userEmail"));
				userlogin.setUserRoom(result.getString("userRoom"));
				userlogin.setUserWechat(result.getString("userWechat"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userlogin;
	}

	@Override
	public boolean register(UserLogin login) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="insert into login(userName,userPassword,userNumber) values (?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login.getUserName());
			pstmt.setString(2, login.getUserPassword());
			pstmt.setString(3, login.getUserNumber());
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updatepwd(UserLogin user) {
		// TODO Auto-generated method stub
		Connection conn=new ConnectDB().getConn();
		String sql="update login set userPassword=? where userName=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUserPassword());
			pstmt.setString(2, user.getUserName());
			int result=pstmt.executeUpdate();
			if(result!=0) {
				return true;
			}
			else return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
