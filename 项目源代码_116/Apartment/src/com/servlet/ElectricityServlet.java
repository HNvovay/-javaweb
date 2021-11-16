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

@WebServlet("/ElectricityServlet")
public class ElectricityServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		if(request.getParameter("Electricity").equals("updatecharge")) {
			Float eleCharge=Float.valueOf(request.getParameter("eleCharge"));
			Connection conn=new ConnectDB().getConn();
			String sql="update elewaterCharge set eleCharge=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setFloat(1, eleCharge);
				int result=pstmt.executeUpdate();
				if(result!=0) {
					request.getRequestDispatcher("electricity.jsp").forward(request,response);
				}else {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改失败，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/electricity.jsp';"
							+ "</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getParameter("Electricity").equals("updatedegree")) {
			Connection conn=new ConnectDB().getConn();
			String roomID=request.getParameter("roomID");
			int eleDegree=Integer.valueOf(request.getParameter("eleDegree"));
			String sql="update renting set eleDegree=? where roomID=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, eleDegree);
				pstmt.setString(2, roomID);
				int result=pstmt.executeUpdate();
				if(result!=0) {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改成功，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/electricity.jsp';"
							+ "</script>");
				}else {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改失败，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/electricity.jsp';"
							+ "</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getParameter("Electricity").equals("updatedegree")) {
			
		}
	}

}
