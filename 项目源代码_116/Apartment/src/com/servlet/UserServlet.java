package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserLogin;
import com.dao.UserDao;
import com.factory.DaoFactory;
import com.util.ConnectDB;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
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
		
		
		//修改管理员密码
		if(request.getParameter("User").equals("updatepwd")) {
			System.out.println("1");
			PrintWriter out = response.getWriter();
			String name = request.getParameter("userName");
			String repwd = request.getParameter("userPassword");
			String repwdagain=request.getParameter("userPasswordagain");
			if(!repwd.equals(repwdagain)) {
				out.print("<script type='text/javascript'>"
						+ "alert('前后两次密码输入有误，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/index.jsp';"
						+ "</script>");
			}
			UserLogin updateuserpwd=new UserLogin(name,repwd);
			UserDao userdao=DaoFactory.getUserDaoInstance();   
			boolean updatepwdresult=userdao.updatepwd(updateuserpwd);
			if(updatepwdresult) {
				out.print("<script type='text/javascript'>"
						+ "alert('修改成功，点击确认返回登录界面重新登陆');"
						+ "window.location.href='"+request.getContextPath()+"/login.jsp';"
						+ "</script>");
			}
			else {
				out.print("<script type='text/javascript'>"
						+ "alert('修改失败，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/index.jsp';"
						+ "</script>");
			}
		}
		//结束
		
		//修改管理员信息开始
		else if(request.getParameter("User").equals("updateusermessage")) {
			PrintWriter out = response.getWriter();
			String name = request.getParameter("userName");
			String wechat=request.getParameter("userWechat");
			String number=request.getParameter("userNumber");
			String room=request.getParameter("userRoom");
			String email=request.getParameter("userEmail");
			String birthday=request.getParameter("userBirthday");
			Connection conn=new ConnectDB().getConn();
			String sql="update login set userWechat=?,userNumber=?,userRoom=?,userEmail=?,userBirthday=? where userName=?";
			HttpSession session=request.getSession();
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, wechat);
				pstmt.setString(2, number);
				pstmt.setString(3, room);
				pstmt.setString(4, email);
				pstmt.setString(5, birthday);
				pstmt.setString(6, name);
				int result=pstmt.executeUpdate();
				if(result!=0) {
					session.setAttribute("userBirthday", birthday);
					out.print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('修改成功，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/index.jsp';"
						+ "</script>");
				}else {
					out.print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改失败，点击确认返回修改页面');"
							+ "window.location.href='"+request.getContextPath()+"/updateusermessage.jsp';"
							+ "</script>");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//结束
		
		//注册管理员信息
		else if(request.getParameter("User").equals("register")) {
			String name = request.getParameter("userName");
			String pwd = request.getParameter("userPassword");
			String num= request.getParameter("userNumber");
			UserLogin login = new UserLogin(name,pwd,num);
			UserDao userdao=DaoFactory.getUserDaoInstance();   
			boolean registerResult=userdao.register(login);
			if(registerResult) {
				response.getWriter().println("<script type='text/javascript'>alert('注册成功，进入登陆界面');"+"window.location.href='"+request.getContextPath()+"/login.jsp';</script>");
			}else {
				response.getWriter().println("<script type='text/javascript'>alert('注册失败，进入注册界面');"+"window.location.href='"+request.getContextPath()+"/register.jsp';</script>");
			}
		}
		//结束
		
		
	}

}
