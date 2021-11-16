package com.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserLogin;
import com.dao.UserDao;
import com.daoimpl.RoomDaoimpl;
import com.factory.DaoFactory;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//处理登录请求
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("userName");
		String pwd = request.getParameter("userPassword");
//		HttpSession session=request.getSession();
		UserLogin login = new UserLogin(name,pwd);
		UserDao userdao=DaoFactory.getUserDaoInstance();   
			try {
		   int result = userdao.login(login);
			if(result== 1){
				//成功
//				session.setAttribute("userName",name);		
				String userName=name;
				UserLogin userlogin=new UserLogin();
				userlogin.setUserName(userName);
				UserDao ud=DaoFactory.getUserDaoInstance();   
				UserLogin user=ud.Loginsucceedtakeuser(userlogin);
				HttpSession session=request.getSession();
				session.setAttribute("userName", user.getUserName());
				session.setAttribute("userPassword", user.getUserPassword());
				session.setAttribute("userRoom", user.getUserRoom());
				session.setAttribute("userEmail", user.getUserEmail());
				session.setAttribute("userNumber", user.getUserNumber());
				session.setAttribute("userWechat", user.getUserWechat());
				session.setAttribute("userBirthday", user.getUserBirthday());
				session.setAttribute("userName", user.getUserName());	
				session.setAttribute("eleCharge", new RoomDaoimpl().getRoomeleCharge());
				session.setAttribute("waterCharge", new RoomDaoimpl().getRoomwaterCharge());
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}else if(result == -1){
				//失败
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().print("<script type='text/javascript'>alert('账号密码错误，点击确认返回登陆界面');"+"window.location.href='"+request.getContextPath()+"/login.jsp';</script>");
			}else{
				System.out.println(result);
			}	
	} catch (Exception e) {
		// TODO: handle exception
	}
	}
 
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
