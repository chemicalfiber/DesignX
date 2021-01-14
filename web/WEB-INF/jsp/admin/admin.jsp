<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gdkmtool" uri="http://gdkm.com/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";;
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>管理员用户管理</title>
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
    <!-- 管理员用户列表查询部分  start-->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">管理员用户管理</h1>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="post" action="${pageContext.request.contextPath}/admin/admin/list.action">
					<div class="form-group">
						<label for="account">管理员登录账号</label> 
						<input type="text" class="form-control" id="account"  name="account" value="${account}" />
					</div>
					<div class="form-group">
						<label for="status">登录状态</label> 
						<select	class="form-control" id="status" name="status">
							<option value="">--请选择--</option>
							<option value="0" <c:if test="${status == '0'}"> selected</c:if> >禁用</option>
							<option value="1" <c:if test="${status == '1'}"> selected</c:if> >正常 </option>		
						</select>
					</div>
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#addDialog" onclick="clearAdmin()" >新建</a>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">管理员用户信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>管理员账号</th>
								<th>管理员用户名</th>
								<th>邮件</th>
								<th>登录状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${page.rows }" var="admin">
								<tr>
									<td>${admin.adminId}</td>
									<td>${admin.account}</td>
									<td>${admin.username}</td>
									<td>${admin.email}</td>
									<td><c:if test="${admin.status == '0'}"> 禁用</c:if> 
									    <c:if test="${admin.status == '1'}"> 正常</c:if></td>
									<td>
										<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#editDialog" 
										   onclick="editAdmin(${admin.adminId})">修改</a>
										<a href="#" class="btn btn-danger btn-xs" 
										   onclick="deleteAdmin(${admin.adminId})">删除</a>
										<a href="#" class="btn btn-success btn-xs" data-toggle="modal" data-target="#editPasswordDialog" 
										   onclick="editAdminPassword(${admin.adminId})">修改密码</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
						<gdkmtool:page url="${pageContext.request.contextPath}/admin/admin/list.action" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 管理员用户列表查询部分  end-->
</div>

<!-- 创建管理员用户模态框 -->
<div class="modal fade" id="addDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新建管理员</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="add_form" >
					<div class="form-group">
						<label for="new_account" class="col-sm-2 control-label"> 登录账号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="登录账号" id="new_account" name="account" />	
						</div>
					</div>
					<div class="form-group">
						<label for="new_password" class="col-sm-2 control-label">登录密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="登录密码" id="new_password" name="password" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_password2" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="确认密码" id="new_password2" />
						</div>
					</div>					
					<div class="form-group">
						<label for="new_username" class="col-sm-2 control-label">用户姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="用户姓名" id="new_username" name="username" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_email" class="col-sm-2 control-label">邮件</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="邮件" id="new_email" name="email" />
						</div>
					</div>
					<div class="form-group">
						<label for="new_status" style="float:left;padding:7px 15px 0 27px;">登陆状态</label>
						<div class="col-sm-10"> 
							<select	class="form-control" id="new_status"  name="status">
								<option value="0" >禁用</option>
								<option value="1"  selected >正常 </option>	
							</select>
						</div>
					</div>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="addAdmin()" >新建管理员</button>
			</div>
		</div>
	</div>
</div>

<!-- 修改管理员用户模态框 -->
<div class="modal fade" id="editDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改管理员信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="edit_form">
				    <input type="hidden" id="edit_adminId" name="adminId"/>
					<div class="form-group">
						<label for="edit_account" class="col-sm-2 control-label">登录账号</label>
						<div class="col-sm-10">				
							<div style="vertical-align:middle;line-height:34px;" id="edit_account" ></div>
						</div>						
					</div>
					<div class="form-group">
						<label for="edit_password" class="col-sm-2 control-label">登录密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="登录密码(不填写则不修改)" id="edit_password" name="password" />
						</div>
					</div>
					<div class="form-group">
						<label for="edit_password2" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-10">
							<input type="password" class="form-control" placeholder="确认密码" id="edit_password2" />
						</div>
					</div>					
					<div class="form-group">
						<label for="edit_username" class="col-sm-2 control-label">用户姓名</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="用户姓名" id="edit_username" name="username" />
						</div>
					</div>
					<div class="form-group">
						<label for="edit_email" class="col-sm-2 control-label">邮件</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="邮件" id="edit_email" name="email" />
						</div>
					</div>
					<div class="form-group">
						<label for="edit_status" style="float:left;padding:7px 15px 0 27px;">登陆状态</label>
						<div class="col-sm-10"> 
							<select	class="form-control" id="edit_status"  name="status">
								<option value="0" >禁用</option>
								<option value="1" >正常 </option>	
							</select>
						</div>
					</div>					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="button" class="btn btn-primary" onclick="updateAdmin()">保存修改</button>
			</div>
		</div>
	</div>
</div>

<!-- 修改管理员密码模态框 -->
<div class="modal fade" id="editPasswordDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">修改管理员密码</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="editPassword_form">
					<input type="hidden"  id="updatePassword_adminId" name="adminId" value="" />
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
//打开新建页面
function clearAdmin(){
	$("#new_account").val("");
	$("#new_password").val("");
	$("#new_password2").val("");
	$("#new_username").val("");
	$("#new_email").val("");
}
//新建管理员
function addAdmin(){
	$.post("<%=basePath%>admin/admin/add.action",$("#add_form").serialize(),
		function(data){
		if(data == "OK"){
			alert("新建管理员成功!");
			window.location.reload();
		}else{
			alert("新建管理员失败!");
		}
	});
}
//删除管理员
function deleteAdmin(adminId){
	if(confirm('确定要删除该管理员用户吗?')){
		$.post("<%=basePath%>admin/admin/delete.action",{"adminId":adminId},
			function(data){
			if(data == "OK"){
				alert("删除管理员成功!");
			}else{
				alert("删除管理员失败!")
			}
			window.location.reload();
		});
	}
}
//通过id获取修改的管理员用户信息
function editAdmin(adminId){
	$.ajax({
		type:"get",
		url:"<%=basePath%>admin/admin/edit.action",
		data:{"adminId":adminId},
		success:function(data){
			$("#edit_adminId").val(data.adminId);
			$("#edit_account").text(data.account);
			$("#edit_password").val("");
			$("#edit_username").val(data.username);
			$("#edit_email").val(data.email);
			$("#edit_status").val(data.status);
		}
	});
}
//修改管理员信息
function updateAdmin(){
	$.post("<%=basePath%>admin/admin/update.action",$("#edit_form").serialize(),
		function(data){
		if(data == "OK"){
			alert("修改管理员信息成功!");
			window.location.reload();
		}else{
			alert("修改管理员信息失败!");
		}
	});
}
//通过用户id修改密码
function editAdminPassword(adminId){
	$("#updatePassword_adminId").val(adminId);
}
//修改管理员密码
function updateAdminPassword(adminId){
	$.post("<%=basePath%>admin/admin/updateAdminPwd.action",$("#editPassword_form").serialize(),
	function(data){
		console.log($("#editPassword_form").serialize());
		if(data == "OK"){
			alert("修改管理员密码成功!");
			window.location.reload();
		}else{
			alert("修改管理员密码失败!");
		}
	});
}		
</script>
</body>
</html>














