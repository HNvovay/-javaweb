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
<script type="text/javascript" src="js/laydate.js"></script>


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
            <div class="crumb-list"><i class="icon-font"></i><a href="index.jsp">首页</a><span class="crumb-step">&gt;</span></span><span>编辑公寓者信息</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
            
            
            <!-- 修改个人信息表单 -->
                <form action="UserServlet?userName=<%=session.getAttribute("userName") %>" method="post" >
                    <table class="insert-tab" width="100%">
                        <tbody><tr>
                            <th width="120"><i class="require-red"></i>管理者ID：</th>
                            <td>
                               <span class="res-lab"><%=session.getAttribute("userName")%></span>
                            </td>
                        </tr>
                            <tr>
                                <th><i class="require-red">*</i>管理员电话：</th>
                                <td>
                                   <input class="common-text required" value="<%=session.getAttribute("userNumber") %>" type="text" name="userNumber" placeholder="TelNumber" required="required" size="50" />
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>管理员微信号：</th>
                                <td><input class="common-text required" type="text" value="<%=session.getAttribute("userWechat") %>" name="userWechat" placeholder="WechatNumber" required="required" size="50" /></td>
                            </tr>
                            <tr>
                                <th>管理员房间：</th>
                                <td><input class="common-text required" value="<%=session.getAttribute("userRoom") %>" type="text" name="userRoom" placeholder="such as:102" required="required" size="50" /></td>
                            </tr>
                            <tr>
                                <th>管理员出生年月：</th>
                                <td>
                                <div><input class="laydate-icon" id="demo" value="<%=session.getAttribute("userBirthday") %>" name="userName" /></div>
                                </td>
                            </tr>
                            <tr>
                                <th>管理员邮箱</th>
                                <td><input class="common-text required" type="text" value="<%=session.getAttribute("userEmail") %>" name="userEmail" placeholder="such as:610232890@qq.com" required="required" size="50" /></td>
                            </tr>
                            <tr>
                                <th></th>
                                <td>
                                	<input type="hidden" name="User" value="updateusermessage">
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


<script type="text/javascript">
        !function () {
            laydate.skin('molv');//切换皮肤，请查看skins下面皮肤库
            laydate({ elem: '#demo' });//绑定元素
        }();

        //日期范围限制
        var start = {
            elem: '#start',
            format: 'YYYY-MM-DD',
            min: laydate.now(), //设定最小日期为当前日期
            max: '2099-06-16', //最大日期
            istime: true,
            istoday: false,
            choose: function (datas) {
                end.min = datas; //开始日选好后，重置结束日的最小日期
                end.start = datas //将结束日的初始值设定为开始日
            }
        };

        var end = {
            elem: '#end',
            format: 'YYYY-MM-DD',
            min: laydate.now(),
            max: '2099-06-16',
            istime: true,
            istoday: false,
            choose: function (datas) {
                start.max = datas; //结束日选好后，充值开始日的最大日期
            }
        };
        laydate(start);
        laydate(end);

        //自定义日期格式
        laydate({
            elem: '#test1',
            format: 'YYYY年MM月DD日',
            festival: true, //显示节日
            choose: function (datas) { //选择日期完毕的回调
                alert('得到：' + datas);
            }
        });

        //日期范围限定在昨天到明天
        laydate({
            elem: '#hello3',
            min: laydate.now(-1), //-1代表昨天，-2代表前天，以此类推
            max: laydate.now(+1) //+1代表明天，+2代表后天，以此类推
        });
</script>






</body>
</html>