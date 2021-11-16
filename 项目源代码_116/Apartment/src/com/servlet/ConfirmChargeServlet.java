package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.ConnectDB;

@WebServlet("/ConfirmChargeServlet")
public class ConfirmChargeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String roomID=request.getParameter("roomID");
		Connection conn=new ConnectDB().getConn();
		String sql="update renting set isCost=? where roomID=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,"已付款");
			pstmt.setString(2, roomID);
			int result=pstmt.executeUpdate();
			if(result!=0) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('确认付款成功，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/Charge.jsp';"
						+ "</script>");
			}else {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('确认付款失败，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/Charge.jsp';"
						+ "</script>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
