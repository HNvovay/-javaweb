<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%if(session.getAttribute("userName")==null || session.getAttribute("userName")==""){
out.print("<script type='text/javascript'>alert('请先登录');location.href='login.jsp';</script>");
return;
} %>
