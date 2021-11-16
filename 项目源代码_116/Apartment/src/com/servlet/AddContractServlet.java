package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspFactory;
import javax.servlet.jsp.PageContext;

import com.bean.Contract;
import com.dao.ContractDao;
import com.factory.DaoFactory;
import com.jspsmart.upload.*;

@WebServlet("/AddContractServlet")
public class AddContractServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String filePath = "/images/contract/";
		 SmartUpload su = new SmartUpload();
		 String name;
		 String contractImg=null;
	      //初始化SmartUpload对象
	      su.initialize(getServletConfig(),request,response);
	      //设置上传文件的最大值
	      su.setMaxFileSize(1024*1024*10);
	      //设置上传文件的总最大值
	      su.setTotalMaxFileSize(1024*1024*100);
	      //设置允许上传文件类型
	      su.setAllowedFilesList("jpg,gif,jpeg,png");
	      try {
	        //设置不允许上传的文件类型
	        su.setDeniedFilesList("rar,txt,mp4,mp3,zip");
	        //上传
	        su.upload();
	        
	        Files files = su.getFiles();
	        com.jspsmart.upload.File file1;
	        file1 = files.getFile(0);
	        name=System.currentTimeMillis()+"HYH"+(long)(Math.random()*100000+666)+"."+file1.getFileExt();
	        contractImg=name;
	        file1.saveAs(filePath+name);
	        System.out.println(name);
	        
	      } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("上传失败！");
	            System.out.println(e.getMessage());
	        }
	      response.setContentType("text/html;charset=UTF-8");
	      String roomID=su.getRequest().getParameter("roomID");
	      String residentID=su.getRequest().getParameter("residentID");
	      Contract contract=new Contract(roomID, residentID, contractImg);
	      System.out.println(roomID+residentID);
	      ContractDao contractdao=DaoFactory.getContractDaoInstance();
	      boolean result=contractdao.addContract(contract);
	      PrintWriter out = response.getWriter();
	      
	      if(result) {
				out.print("<script type='text/javascript'  language='javaScript'>"
					+ "alert('新增成功，点击确认返回首页');"
					+ "window.location.href='"+request.getContextPath()+"/Contract.jsp';"
					+ "</script>");
			}else {
				out.print("<script type='text/javascript'  language='javaScript'>"
						+ "alert('失败，点击确认返回修改页面');"
						+ "window.location.href='"+request.getContextPath()+"/addContract.jsp';"
						+ "</script>");
			}
	      
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
