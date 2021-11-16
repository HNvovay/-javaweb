package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Resident;
import com.dao.ResidentDao;
import com.factory.DaoFactory;

@WebServlet("/ResidentServlet")
public class ResidentServlet extends HttpServlet {

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
		
		
		//查询住户
		if(request.getParameter("Resident").equals("check")) {
			String check=request.getParameter("checkresident");
			ResidentDao result=DaoFactory.getResidentDaoInstance();
			ResultSet rs=result.selectResident(check);
				if(rs!=null) {
					request.setAttribute("result", rs);
					request.getRequestDispatcher("resident.jsp").forward(request,response);
				}else if (rs==null) {
					response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('查询失败，点击确认返回页面');"
							+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
							+ "</script>");
					System.out.println("00");
				}
		}
		//结束
		
		//批量删除
		else if(request.getParameter("Resident").equals("alldelete")) {
			String [] allresidentID=request.getParameterValues("checkAll");
			response.setContentType("text/html;charset=UTF-8");
			if(request.getParameter("checkAll")==null) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('请选择需要删除的数据，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
						+ "</script>");
			}
			
			ResidentDao residentdao=DaoFactory.getResidentDaoInstance();
			boolean result=false;
			for(int i=0;i<allresidentID.length;i++) {
				result=residentdao.deleteResident(new Resident(allresidentID[i]));
			}
			if(result) {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('删除成功，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
						+ "</script>");
			}else {
				response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('删除失败，点击确认返回首页');"
						+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
						+ "</script>");
			}
		}
		//结束
		
		//删除
				else if(request.getParameter("Resident").equals("delete")) {
					String residentID=request.getParameter("residentID");
					response.setContentType("text/html;charset=UTF-8");
					Resident resident=new Resident(residentID);
					ResidentDao residentdao=DaoFactory.getResidentDaoInstance();
					boolean result=residentdao.deleteResident(resident);
					if(result) {
						response.sendRedirect("resident.jsp");
					}else {
						response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('删除失败，点击确认返回首页');"
								+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
								+ "</script>");
					}
				}
		//结束
		
		//新增
				else if(request.getParameter("Resident").equals("add")) {
					PrintWriter out = response.getWriter();
					String residentID=request.getParameter("residentID");
					String residentName=request.getParameter("residentName");
					String residentAge=request.getParameter("residentAge");
					String residentNumber=request.getParameter("residentNumber");
					String residentProfession=request.getParameter("residentProfession");
					String residentIDCardNum=request.getParameter("residentIDCardNum");
					String remarks=request.getParameter("remarks");
					ResidentDao residentDao=DaoFactory.getResidentDaoInstance();
					Resident newmessageresident=new Resident(residentID, residentName, residentAge, residentNumber, residentProfession, remarks, residentIDCardNum);
					boolean result=residentDao.addResident(newmessageresident);
					if(result) {
						out.print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('新增成功，点击确认返回首页');"
							+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
							+ "</script>");
					}else {
						out.print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('ID重复，点击确认返回修改页面');"
								+ "window.location.href='"+request.getContextPath()+"/addResident.jsp';"
								+ "</script>");
					}
				}
		//结束
		
		//修改
				else if(request.getParameter("Resident").equals("update")) {
					PrintWriter out = response.getWriter();
					String residentID=request.getParameter("residentID");
					String residentName=request.getParameter("residentName");
					String residentAge=request.getParameter("residentAge");
					String residentNumber=request.getParameter("residentNumber");
					String residentProfession=request.getParameter("residentProfession");
					String residentIDCardNum=request.getParameter("residentIDCardNum");
					String remarks=request.getParameter("remarks");
					ResidentDao residentDao=DaoFactory.getResidentDaoInstance();
					Resident newmessageresident=new Resident(residentID, residentName, residentAge, residentNumber, residentProfession, remarks, residentIDCardNum);
					boolean result=residentDao.updateResident(newmessageresident);
					if(result) {
						out.print("<script type='text/javascript'  language='javaScript'>"
							+ "alert('修改成功，点击确认返回首页');"
							+ "window.location.href='"+request.getContextPath()+"/resident.jsp';"
							+ "</script>");
					}else {
						out.print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('修改失败，点击确认返回修改页面');"
								+ "window.location.href='"+request.getContextPath()+"/updatresidentmessage.jsp';"
								+ "</script>");
					}
				}
		//结束
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
