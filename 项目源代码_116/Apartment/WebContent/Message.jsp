<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.util.ConnectDB"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ include file="checksession.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>公寓管理系统</title>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/main.css"/>
<link rel="SHORTCUT ICON" href="images/Apartment.ico"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="index.html" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="index.jsp">首页</a></li>
                <li><img src="images/logoindex.jpg" style="width: 80px;height: 40px;"></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>管理员ID：&nbsp <%=session.getAttribute("userName") %></li>
<!----------------------------------------退出弹窗script------------------------------------------------------>
                <script type="text/javascript" language="javaScript">
                function del(){
                	if(confirm("确认注销账户？")){
                	window.location.href = "ExitServlet";
                	}else{
                		return;}
                	}
                </script>
 <!----------------------------------------退出弹窗script------------------------------------------------------>
                <li><a href="#" onclick="del()">注销</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>Menu</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="resident.jsp"><i class="icon-font">&#xe003;</i>用户信息管理</a>
                    <ul class="sub-menu">
                        <li><a href="resident.jsp"><i class="icon-font">&#xe005;</i>用户基本信息管理</a></li>
                        <li><a href="Contract.jsp"><i class="icon-font">&#xe006;</i>合同管理</a></li>
                        <li><a href="Charge.jsp"><i class="icon-font">&#xe004;</i>账单管理</a></li>
                        <li><a href="Message.jsp"><i class="icon-font">&#xe012;</i>发布消息</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="icon-font">&#xe046;</i>公寓管理</a>
                    <ul class="sub-menu">
                        <li><a href="room.jsp"><i class="icon-font">&#xe008;</i>公寓基本信息管理</a></li>
                        <li><a href="electricity.jsp"><i class="icon-font">&#xe052;</i>电费管理</a></li>
                        <li><a href="water.jsp"><i class="icon-font">&#xe005;</i>水费管理</a></li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span><span>发布消息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            
            
            <!-- 修改个人信息表单 -->
                <form action="MessageServlet" method="post">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                          <th width="120"><i class="require-red">*</i>用户ID</th>
                            <td>
                                <select name="colId" id="select" onfocus="selectFocus()"class="required">
                                    <option value="">请选择用户</option>
                                  
                                  <%Connection  conn=new ConnectDB().getConn();
                                  	String sql="select * from resident order by residentID+0";
                                  	PreparedStatement pstmt=conn.prepareStatement(sql);
                                  	ResultSet result=pstmt.executeQuery();     
                                  	while(result.next()){
                                  %> 
                                    <option onclick="selectClick()" value="<%=result.getString("residentID") %>"><%=result.getString("residentID") %>&nbsp<%=result.getString("residentName") %></option>
                                     <%} %>
                                </select>
                            </td>
                            
<script type="text/javascript"> 
function selectFocus(){ 
document.getElementById("select").setAttribute("size","5"); //修改数据
} 
//点击添加size属性
function selectClick(){ 
document.getElementById("select").removeAttribute("size"); 
document.getElementById("select").blur(); 
this.setAttribute("selected",""); 
}
//点击删除size属性 
</script> 
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>标题：</th>
                                <td>
                                    <input class="common-text required" id="title" name="title" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>作者：</th>
                                <td><input class="common-text" name="author" size="50" value="<%=session.getAttribute("userName") %>" type="text"></td>
                            </tr>
                            <tr>
                                <th>内容：</th>
                                <td><textarea name="content" class="common-textarea" id="content" placeholder="200个字以内" cols="30" style="width: 98%;" rows="10"></textarea></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>