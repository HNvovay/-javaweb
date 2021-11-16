package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Contract;
import com.dao.ContractDao;
import com.dao.ResidentDao;
import com.factory.DaoFactory;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;

@WebServlet("/ContractServlet")
public class ContractServlet extends HttpServlet {

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
		
		
		//查询合同(账单、电费、水费也可使用)
				if(request.getParameter("Contract").equals("check")) {
					String check=request.getParameter("checkcontract");
					ContractDao result=DaoFactory.getContractDaoInstance();
					ResultSet rs=result.selectContract(check);
					if(rs!=null) {
						if(request.getParameter("Charge")!=null) {
						request.setAttribute("result", rs);
						request.getRequestDispatcher("Charge.jsp").forward(request,response);
						}else if(request.getParameter("electricity")!=null){
							request.setAttribute("result", rs);
							request.getRequestDispatcher("electricity.jsp").forward(request,response);
						}else if(request.getParameter("water")!=null){
							request.setAttribute("result", rs);
							request.getRequestDispatcher("water.jsp").forward(request,response);
						}else if(request.getParameter("contract")!=null) {
						request.setAttribute("result", rs);
						request.getRequestDispatcher("Contract.jsp").forward(request,response);
						}
					}else if (rs==null) {
						if(request.getParameter("Charge")!=null) {
							response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
									+ "alert('查询失败，点击确认返回修改页面');"
									+ "window.location.href='"+request.getContextPath()+"/Charge.jsp';"
									+ "</script>");
						}else if(request.getParameter("electricity")!=null){
							response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
									+ "alert('查询失败，点击确认返回修改页面');"
									+ "window.location.href='"+request.getContextPath()+"/electricity.jsp';"
									+ "</script>");
						}else if(request.getParameter("water")!=null){
							response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
									+ "alert('查询失败，点击确认返回修改页面');"
									+ "window.location.href='"+request.getContextPath()+"/water.jsp';"
									+ "</script>");
						}else {
						response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('查询失败，点击确认返回修改页面');"
								+ "window.location.href='"+request.getContextPath()+"/Contract.jsp';"
								+ "</script>");
							}
					}
				}
		//结束
				
		//批量删除
				else if(request.getParameter("Contract").equals("alldelete")) {
					String [] allroomID=request.getParameterValues("checkAll");
					response.setContentType("text/html;charset=UTF-8");
					if(request.getParameter("checkAll")==null) {
						response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('请选择需要删除的数据，点击确认返回首页');"
								+ "window.location.href='"+request.getContextPath()+"/Contract.jsp';"
								+ "</script>");
					}
					ContractDao contractdao=DaoFactory.getContractDaoInstance();
					boolean result=false;
					for(int i=0;i<allroomID.length;i++) {
						result=contractdao.deleteContract(new Contract(allroomID[i]));
					}
					if(result) {
						if(request.getParameter("Charge").equals("alldelete")) {
							response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
									+ "alert('删除成功，点击确认返回首页');"
									+ "window.location.href='"+request.getContextPath()+"/Charge.jsp';"
									+ "</script>");
						}else if(request.getParameter("Electricity").equals("alldelete")) {
							response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
									+ "alert('删除成功，点击确认返回首页');"
									+ "window.location.href='"+request.getContextPath()+"/electricity.jsp';"
									+ "</script>");
						}else if(request.getParameter("Water").equals("alldelete")) {
							response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
									+ "alert('删除成功，点击确认返回首页');"
									+ "window.location.href='"+request.getContextPath()+"/water.jsp';"
									+ "</script>");
						}else {
						response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('删除成功，点击确认返回首页');"
								+ "window.location.href='"+request.getContextPath()+"/Contract.jsp';"
								+ "</script>");
						}
					}else {
						response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('删除失败，点击确认返回首页');"
								+ "window.location.href='"+request.getContextPath()+"/Contract.jsp';"
								+ "</script>");
					}
				}
				
		//结束	
				
		//删除
				else if(request.getParameter("Contract").equals("delete")) {
					String roomID=request.getParameter("roomID");
					response.setContentType("text/html;charset=UTF-8");
					Contract contract=new Contract(roomID);
					ContractDao contractdao=DaoFactory.getContractDaoInstance();
					boolean result=contractdao.deleteContract(contract);
					if(result) {
						response.sendRedirect("Contract.jsp");
					}else {
						response.getWriter().print("<script type='text/javascript'  language='javaScript'>"
								+ "alert('删除失败，点击确认返回首页');"
								+ "window.location.href='"+request.getContextPath()+"/Contract.jsp';"
								+ "</script>");
					}
				}
		//结束
		
		//新增
				//在AddContractServlet中
		//结束
				
				
				
				
				
				
	}

}
