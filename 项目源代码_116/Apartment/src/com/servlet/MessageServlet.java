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

@WebServlet("/MessageServlet")
public class MessageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		String colID=request.getParameter("colId");
		String title=request.getParameter("title");
		String author=request.getParameter("author");
		String content=request.getParameter("content");
		Connection conn=new ConnectDB().getConn();
		String sql="insert into Message(residentID,title,author,content) values (?,?,?,?)";
		int result=0;
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, colID);
			pstmt.setString(2, title);
			pstmt.setString(3, author);
			pstmt.setString(4, content);
			result=pstmt.executeUpdate();
			if(result!=0) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('留言成功，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/Message.jsp';"
						+ "</script>");
			}else {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('留言失败，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/Message.jsp';"
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
