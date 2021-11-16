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


@WebServlet("/WaterServlet")
public class WaterServlet extends HttpServlet {
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
		if(request.getParameter("Water").equals("watercharge")) {
			Float waterCharge=Float.valueOf(request.getParameter("waterCharge"));
			Connection conn=new ConnectDB().getConn();
			String sql="update elewaterCharge set waterCharge=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setFloat(1, waterCharge);
				int result=pstmt.executeUpdate();
				if(result!=0) {
					request.getRequestDispatcher("water.jsp").forward(request,response);
				}else {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改失败，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/water.jsp';"
							+ "</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(request.getParameter("Water").equals("waterdegree")) {
			Connection conn=new ConnectDB().getConn();
			String roomID=request.getParameter("roomID");
			int waterDegree=Integer.valueOf(request.getParameter("waterDegree"));
			String sql="update renting set waterDegree=? where roomID=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, waterDegree);
				pstmt.setString(2, roomID);
				int result=pstmt.executeUpdate();
				if(result!=0) {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改成功，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/water.jsp';"
							+ "</script>");
				}else {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改失败，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/water.jsp';"
							+ "</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
