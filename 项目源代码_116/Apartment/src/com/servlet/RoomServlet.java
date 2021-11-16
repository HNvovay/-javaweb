package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Room;
import com.dao.RoomDao;
import com.factory.DaoFactory;

@WebServlet("/RoomServlet")
public class RoomServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		if(request.getParameter("Room").equals("check")) {
			String check=request.getParameter("checkroom");
			RoomDao result=DaoFactory.getRoomDaoInstance();
			ResultSet rs=result.selectRoom(check);
			if(rs!=null) {
				request.setAttribute("result", rs);
				request.getRequestDispatcher("room.jsp").forward(request,response);
			}else if (rs==null) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('查询失败，点击确认返回修改页面');"
						+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
						+ "</script>");
				System.out.println("00");
			}
		}else if(request.getParameter("Room").equals("delete")) {
			String roomID=request.getParameter("roomID");
			Room room=new Room(roomID);
			RoomDao roomdao=DaoFactory.getRoomDaoInstance();
			boolean result=roomdao.deleteRoom(room);
			if(result) {
				response.sendRedirect("room.jsp");
			}else {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('删除失败，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
						+ "</script>");
			}
		}else if(request.getParameter("Room").equals("alldelete")) {
			String [] allroomID=request.getParameterValues("checkAll");
			response.setContentType("text/html;charset=UTF-8");
			if(request.getParameter("checkAll")==null) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('请选择需要删除的数据，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
						+ "</script>");
			}
			RoomDao roomdao=DaoFactory.getRoomDaoInstance();
			boolean result=false;
			for(int i=0;i<allroomID.length;i++) {
				result=roomdao.deleteRoom(new Room(allroomID[i]));
			}
			if(result) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('删除成功，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
						+ "</script>");
			}else {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('删除失败，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
						+ "</script>");
			}
		}else if(request.getParameter("Room").equals("add")) {
			PrintWriter out = response.getWriter();
			String roomID=request.getParameter("roomID");
			String roomStyle=request.getParameter("roomStyle");
			String roomStroey=request.getParameter("roomStroey");
			RoomDao RoomDao=DaoFactory.getRoomDaoInstance();
			Room room=new Room(roomID, roomStyle, roomStroey);
			boolean result=RoomDao.addRoom(room);
			if(result) {
				out.print("<script type='text/javascript'  language='javaScript'>"
					+ "alert('新增成功，点击确认返回首页');"
					+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
					+ "</script>");
			}else {
				out.print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('ID重复或者房间类型填写错误，点击确认返回修改页面');"
						+ "window.location.href='"+request.getContextPath()+"/addRoom.jsp';"
						+ "</script>");
			}
		}else if(request.getParameter("Room").equals("update")) {
			PrintWriter out = response.getWriter();
			String roomID=request.getParameter("roomID");
			String roomStyle=request.getParameter("roomStyle");
			String roomStroey=request.getParameter("roomStroey");
			RoomDao roomDao=DaoFactory.getRoomDaoInstance();
			Room newroom=new Room(roomID, roomStyle, roomStroey);
			boolean result=roomDao.updateRoom(newroom);
			if(result) {
				out.print("<script type='text/javascript'  language='javaScript'>"
					+ "alert('修改成功，点击确认返回首页');"
					+ "window.location.href='"+request.getContextPath()+"/room.jsp';"
					+ "</script>");
			}else {
				out.print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('修改失败，点击确认返回修改页面');"
						+ "window.location.href='"+request.getContextPath()+"/updateroommessage.jsp';"
						+ "</script>");
			}
		}
	}

}
