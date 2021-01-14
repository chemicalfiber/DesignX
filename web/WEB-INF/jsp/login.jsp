<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>DesignX工作室后台登录</title>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/css/style.css" type=text/css rel=stylesheet>
<link href="${pageContext.request.contextPath}/css/boot-crm.css" type=text/css rel=stylesheet>
<script src="${pageContext.request.contextPath}/js/jquery.js">
</script>
<meta content="MSHTML 6.00.2600.0" name=GENERATOR>
<script>
// 判断是登录账号和密码是否为空
function check(){
    var account = $("#account").val();
    var password = $("#password").val();
    if(account=="" || password==""){
    	$("#message").text("账号或密码不能为空！");
        return false;
    }  
    return true;
}
</script>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0" background="${pageContext.request.contextPath}/images/desk.jpeg">
<div ALIGN="center">
<table border="0" width="1140px" cellspacing="0" cellpadding="0" id="table1">
	<tr>
		<td height="93"></td>
		<td></td>
	</tr>
	<tr>
<%--   <td background="${pageContext.request.contextPath}/images/desk.jpeg" width="740" height="412">--%>
<%--   </td>--%>
   <td class="login_msg" width="400" align="center">
	 <!-- margin:0px auto; 控制当前标签居中 -->
	 <fieldset style="width: auto; margin: 0px auto;">
		  <legend>
		     <font style="font-size:18px; font-weight: bolder" face="宋体" >
		                             欢迎使用DesignX后台管理系统
		     </font>
		  </legend> 
		<font color="red">
			 <%-- 提示信息--%>
			 <span id="message">${msg}</span>
		</font>
		<form action="${pageContext.request.contextPath}/admin/login.action" method="post" onsubmit="return check()">
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />
			<font style="font-weight: bolder">账 号：</font><input id="account" type="text" name="account" /><br /><br />
			<font style="font-weight: bolder">密&nbsp;码：</font><input id="password" type="password" name="password" /><br /><br />
            <div align="center"><input id="btnsubmit" type="submit" value="登录" /></div>
		 </form>
	 </fieldset>
	</td>
	</tr>
</table>
</div>
</body>
</html>
