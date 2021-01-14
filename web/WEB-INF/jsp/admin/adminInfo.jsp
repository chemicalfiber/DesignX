<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gdkmtool" uri="http://gdkm.com/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>后台个人信息</title>
	<!-- 引入css样式文件 -->
	<!-- Bootstrap Core CSS -->
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet" />
	<!-- MetisMenu CSS -->
	<link href="${pageContext.request.contextPath}/css/metisMenu.min.css" rel="stylesheet" />
	<!-- DataTables CSS -->
	<link href="${pageContext.request.contextPath}/css/dataTables.bootstrap.css" rel="stylesheet" />
	<!-- Admin CSS -->
	<link href="${pageContext.request.contextPath}/css/sb-admin-2.css" rel="stylesheet" />
	<!-- Admin Fonts -->
	<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
	<link href="${pageContext.request.contextPath}/css/boot-crm.css" rel="stylesheet" type="text/css" />
	<!-- jQuery -->
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<!-- Metis Menu Plugin JavaScript -->
	<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
	<!-- DataTables JavaScript -->
	<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
	<!-- Admin Theme JavaScript -->
	<script src="${pageContext.request.contextPath}/js/sb-admin-2.js"></script>
	<!-- Validate JavaScript -->
	<script src="${pageContext.request.contextPath}/js/jquery.validate.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.validate.messages_cn.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.form.js"></script>	
</head>
<body>
<div id="wrapper">
    <!-- 导航栏部分  start-->
    <%@ include file="nav.jsp" %>
    <!-- 导航栏部分 end -->    
    <!-- 用户信息部分  start-->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">后台个人信息</h1>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#editPasswordDialog" onclick="">修改密码</a>
		<div class="row">
			<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-body">
					<form id="info_form" class="form-inline" method="post" action="" >
						<div class="col-sm-10">
							<label >登录账号：</label> 
							${adminInfo.account}
							<input type="hidden" id="adminId"  name="adminId" value="${adminInfo.adminId}" />
						</div>
						<div class="col-sm-10">
							<label >用户姓名：</label> 
							<input type="text" class="form-control" id="username"  name="username" value="${adminInfo.username}" />
						</div>																
						<div class="col-sm-10">
							<label for="title">电子邮件：</label> 
							<input type="text" class="form-control" id="email"  name="email" value="${adminInfo.email}" />
						</div>						
						<div class="col-sm-10">
							<label for="title">登陆状态：</label>
 							<c:if test="${adminInfo.status == '0'}">禁用</c:if>
 							<c:if test="${adminInfo.status == '1'}">正常</c:if>
						</div>
						<div class="col-sm-10">
							<br><button type="button" class="btn btn-primary" onclick="updateAdmin()" >提交修改</button>
						</div>						
					</form>
				</div>
			</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 用户信息部分  end-->
</div>

<!-- 修改个人密码模态框 -->
<div class="modal fade" id="editPasswordDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改密码</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="editPassword_form">
					<div class="form-group">
						<label for="oldPassword" class="col-sm-2 control-label">旧密码</label>
						<div class="col-sm-10">				
							<input type="password" class="form-control" placeholder="输入旧密码" id="oldPassword" name="oldPassword" />
						</div>						
					</div>
					<div class="form-group">
						<label for="newPassword" class="col-sm-2 control-label">新密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="输入新密码" id="newPassword" name="password" />
						</div>
					</div>
					<div class="form-group">
						<label for="newPassword2" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="确认新密码" id="newPassword2" />
						</div>
					</div>					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateAdminPassword()">保存修改</button>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
//修改当前用户信息
function updateAdmin(){
	$.post("<%=basePath%>admin/admin/update.action",$("#info_form").serialize(),
		function(data){
			if(data == "OK"){
				alert("修改个人信息成功!");
			}else{
				alert("修改个人信息失败!");
			}
	});
}
//修改当前用户密码
function updateAdminPassword(adminId){
	$.post("<%=basePath%>admin/admin/updateAdminPwd.action",$("#editPassword_form").serialize(),
		function(data){
			if(data == "OK"){
				alert("修改密码成功!");
				window.location.reload();
			}else{
				alert("修改密码失败!");
			}
	});
}
</script>
</body>
</html>










