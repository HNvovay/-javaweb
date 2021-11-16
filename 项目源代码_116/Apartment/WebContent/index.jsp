<%@page import="java.util.Date"%>
<%@page import="javafx.scene.chart.PieChart.Data"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ include file="checksession.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/updatepwd.css"/>
    <link rel="stylesheet" type="text/css" href="css/button.css"/>
    <link rel="SHORTCUT ICON" href="images/Apartment.ico"/>
   
	
<title>公寓管理系统首页</title>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
</head>
<body>

<!----------------------------------------修改密码弹窗开始------------------------------------------------------>

<!--遮罩层-->
<div class="bgPop"></div>
<!--弹出框-->
<div class="pop">
    <div class="pop-top">
        <h2>修改管理员密码</h2>
        <span class="pop-close">Ｘ</span>
    </div>
    <form action="UserServlet?userName=<%=session.getAttribute("userName")%>" method="post">
	    <div class="pop-content">
	        <div class="pop-content-left">
	            <img src="" alt="" class="teathumb">
	        </div>
	     
	        <div class="pop-content-right">
	            
				<h1 style="position: absolute;left:200px;top:100px;font-size: 30px;">你需要填写以下信息:</h1>
				<p  style="position: absolute;left:100px;top:200px;font-size: 20px;" >请输入新的密码: &nbsp <input style="font-size:20px;" type="text" name="userPassword"  /></p>
				<p  style="position: absolute;left:100px;top:250px;font-size: 20px;" >请再次输入密码: &nbsp <input style="font-size:20px;" type="text" name="userPasswordagain"   /></p>
	        </div>
	    </div>
	    <div class="pop-foot">
	   		<input type="hidden" value="updatepwd"  name="User"/>
	        <input type="button" value="关闭" class="pop-cancel pop-close"/>
	        <input type="submit" value="确定" class="pop-ok"/>
	    </div>
	</form>
</div>
<script>
    $(document).ready(function () {
        $('.pop-close').click(function () {
            $('.bgPop,.pop').hide();
        });
        $('.click_pop').click(function () {
            $('.bgPop,.pop').show();
        });
    })

</script>
<div style="text-align:center;">
</div>

<!----------------------------------------修改密码弹窗结束------------------------------------------------------>

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
                <li><a href="javascript:void(0)" class="click_pop">修改密码</a></li>
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
                    <a href="#"><i class="icon-font">&#xe003;</i>用户信息管理</a>
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
            <div class="crumb-list"><i class="icon-font">&#xe06b;</i><span>Welcome to Huang's apartment management system platform</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>常用快捷操作</h1>
            </div>
            <div class="result-content">
                <div class="short-wrap">
                    <a href="addResident.jsp"><i class="icon-font">&#xe001;</i>新增用户信息</a>
                    <a href="addContract.jsp"><i class="icon-font">&#xe005;</i>新增合同信息</a>
                    <a href="addRoom.jsp"><i class="icon-font">&#xe048;</i>新增公寓信息</a>
                    <a href="Message.jsp"><i class="icon-font">&#xe012;</i>发布消息</a>
                </div>
            </div>
        </div>
        <div class="result-wrap">
            <div class="result-title">
                <h1>公寓管理员基本信息</h1>
            </div>
            <div class="result-content">
                <ul class="sys-info-list">
                	<li>
                        <button class="small blue button" onclick="javascrtpt:window.location.href='updateusermessage.jsp'">编辑基本资料</button>
                    </li>
                    <li>
                        <label class="res-lab">管理员ID:</label>&nbsp &nbsp<span class="res-info"><%=session.getAttribute("userName")%></span>
                    </li>
                    <li>
                        <label class="res-lab">管理员电话:</label>&nbsp &nbsp<span class="res-info"><%=session.getAttribute("userNumber")%></span>
                    </li>
                    <li>
                        <label class="res-lab">管理员微信号:</label>&nbsp &nbsp<span class="res-info"><%=session.getAttribute("userWechat") %></span>
                    </li>
                     <li>
                        <label class="res-lab">管理员房间号:</label>&nbsp &nbsp<span class="res-info"><%=session.getAttribute("userRoom") %></span>
                    </li>
                    <li>
                        <label class="res-lab">管理员出生年月:</label>&nbsp &nbsp<span class="res-info"><%=session.getAttribute("userBirthday") %></span>
                    </li>
                    <li>
                        <label class="res-lab">管理员邮箱:</label>&nbsp &nbsp<span class="res-info"><%=session.getAttribute("userEmail") %></span>
                    </li>
                    <li>
                    <%
						Date d=new Date();
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String now = df.format(d);
					%>
                        <label class="res-lab">管理员登陆时间:</label>&nbsp &nbsp<span class="res-info"><%=now %></span>
                    </li>
                    <li>
                        <label class="res-lab">管理员登陆服务器名:</label>&nbsp &nbsp<span class="res-info"><%=request.getServerName() %></span>
                    </li>
                    <li>
                        <label class="res-lab">Host:</label>&nbsp &nbsp<span class="res-info"><%=request.getRemoteHost() %></span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>