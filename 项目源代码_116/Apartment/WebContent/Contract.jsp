<%@page import="com.util.ConnectClose"%>
<%@page import="com.daoimpl.ResidentDaoimpl"%>
<%@page import="com.daoimpl.RoomDaoimpl"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.util.ConnectDB"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ include file="checksession.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="SHORTCUT ICON" href="images/Apartment.ico"/>
<link rel="stylesheet" type="text/css" href="css/common.css"/>
<link rel="stylesheet" type="text/css" href="css/demo.css"/>
 <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" type="text/css" href="css/updatepwd.css"/>
    <link rel="stylesheet" type="text/css" href="css/button.css"/>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript" src="js/choose.js"></script>

<title>Contract</title>
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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span></span><span>合同基本信息管理</span></div>
        </div>
        
     <!-- 查询 -->   
         <div class="search-wrap">
            <div class="search-content">
                <form action="ContractServlet?contract=1" method="post">
                <input type="hidden" name="Contract" value="check">
                    <table class="search-tab">
                        <tr>
                            <th width="150">请输入用户ID或公寓ID:</th>
                            <td><input class="common-text" placeholder="such as:102" name="checkcontract" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr>
                    </table>
                </form>
            </div>
        </div>
        
        <!-- 数据表 -->
        <div class="result-wrap">
            <form  action="ContractServlet" name="myform" id="myform" method="post">
            <input type="hidden" name="Contract" value="alldelete">
            <!-- 功能 -->
                <div class="result-title">
                    <div class="result-list">
                        <a href="addContract.jsp"><i class="icon-font"></i>新增合同</a>
                        <script language='javascript'>
							var obj=document.getElementById('myform');
							function go(){
							obj.submit();//表单中的参数会一起提交
							}
						</script>
                        <a id="myhref" href="#" onclick="go();"><i class="icon-font"></i>批量删除</a>
                        <a id="updateOrd" href="Contract.jsp"><i class="icon-font"></i>刷新</a>
                    </div>
                </div>
                
                <!-- 真正的数据表 -->
                <div class="result-content">
                    <table class="result-tab" width="100%">
                    
                        <tr>
                            <th class="tc" width="7%">All &nbsp<input type="checkbox" id="selAll" onclick="selectAll();" />In &nbsp<input type="checkbox" id="inverse" onclick="notSelectAll();" /></th>
                            <th>住户ID</th>
                            <th>住户姓名</th>
                            <th>房间ID</th>
                            <th>相关合同</th>                           
                            <th></th>
                        </tr>
                   <!-- 列表判断 --> 
                   <%
							//设置每张网页显示三笔记录(每页显示的记录数)
							int PageSize=10;
							//设置欲显示的页数(初始页)
							int ShowPage=1;
							//ResultSet的记录笔数(总记录数)
							int RowCount=0;
							//ResultSet分页后的总数(总页数)
							int PageCount=0;
							ResultSet result=null;
							Connection conn=null;
							PreparedStatement pstmt=null;
					%>
					<jsp:useBean id="cdb" scope="page" class="com.util.ConnectDB"></jsp:useBean>
							<%
							//连接数据库并初始数据
							if((ResultSet)request.getAttribute("result")==null)
							{
							conn=cdb.getConn();
							 String sql = "select * from renting order by residentID+0 ASC";
							 pstmt = conn.prepareStatement(sql);
							 result = pstmt.executeQuery();
							}else{
								 result = (ResultSet)request.getAttribute("result");
							}
							//将指标移至最后一条记录
							result.last();
							//获取记录总数
							RowCount=result.getRow();
							//计算显示的页数(关键)
							PageCount=((RowCount%PageSize)==0?(RowCount/PageSize):(RowCount/PageSize)+1);
							%>
                       <%
						String ToPage=request.getParameter("ToPage");
						//判断是否取得ToPage参数
						if(ToPage!=null)
						{
						//取得指定显示的分页页数
						ShowPage=Integer.parseInt(ToPage);
						//下面的语句判断用户输入的页数是否正确
						if(ShowPage>=PageCount)
						{
						ShowPage=PageCount;
						}
						else if(ShowPage<=0)
						{
						ShowPage=1;
						}
						}
						//计算欲显示页的第一笔记录位置
						result.absolute((ShowPage-1)*PageSize+1);
						%>
                     	  <%
							//利用for循环配合PageSize属性取出一页中的数据
							for(int i=1;i<=PageSize;i++)
							{
							%>               			
                        <tr>              				        				
                            <td class="tc"><input type="checkbox" name="checkAll" id="checkAll" onclick="setSelectAll();" value="<%=result.getString("roomID")%>"/></td>                          
                            <td><%=result.getString("residentID") %></td>
                             <td><a href="checkResidentServlet?checkresident=<%=new ResidentDaoimpl().getResidentName(result.getString("residentID")) %>"><%=new ResidentDaoimpl().getResidentName(result.getString("residentID")) %></a></td>
                            <td><a href="checkRoomServlet?checkroom=<%=result.getString("roomID") %>"><%=result.getString("roomID") %></a></td>
                            <td><a href="<%=result.getString("contractImg") %>" target="_blank">点击查看图片</a></td>                       
                            <td>                         
                                <a class="link-del" href="ContractServlet?roomID=<%=result.getString("roomID")%>&Contract=delete"  onclick="return confirm('确定删除?');">删除</a>
                            </td>                    
                        </tr>

                      <%
							//下面的语句用于输出最后一条记录时,将指针移到最后一笔记录之后
							if(!result.next())
							{
							//跳出for循环
							break;
							}
							}
                     	
						%>
                    </table>
             
                    <div class="black2">
                    	<%if(ShowPage==1){%>                   	
							<span class="disabled"> < </span>
						<%}else{%>
							<a href="Contract.jsp?ToPage=<%=ShowPage-1 %>"> < </a>
						<%} %>
						<%for(int i=1;i<=PageCount;i++) {%>	
						<%if(ShowPage==i) {%>
							<span class="current"><%=i %></span>
							<%}else{%>			
							<a  href="Contract.jsp?ToPage=<%=i%>"><%=i%></a>
							<%} %>
						<%} %>	
						<%if(ShowPage==PageCount){ %>						
							<span class="disabled"> > </span>
						<%}else{%>
							<a href="Contract.jsp?ToPage=<%=ShowPage+1 %>"> > </a>
						<%} %>
					</div>
                	</div>
            </form>
        </div>

        

    </div>
    <!--/main-->
</div>
</body>
</html>