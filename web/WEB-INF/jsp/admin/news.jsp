<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="gdkmtool" uri="http://gdkm.com/common/"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" +request.getServerName()+ ":" +request.getServerPort()
    + path + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>项目管理</title>
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
	<!-- ---------开始设置kindeitor ------------ -->
	<script charset="utf-8" src="${pageContext.request.contextPath}/js/editor/kindeditor.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/js/editor/lang/zh_CN.js"></script>
	<script charset="utf-8" src="${pageContext.request.contextPath}/js/editor/kindEditorReady.js"></script>
	<script>
	KindEditor.ready(function(K) {
	        window.editor = K.create('#new_message');//此处new_message为<textarea id="new_message" name=message></textarea>的id属性值
	});
	
	var options = {
	cssPath : '/css/index.css',
	filterMode : true
	};
	var editor = K.create('textarea[name="message"]', options);//此处message为<textarea id="new_message" name=message></textarea>的name属性值
	
	// 取得HTML内容
	html = editor.html();
	
	// 同步数据后可以直接取得textarea的value
	editor.sync();
	html = document.getElementById('new_message').value; 
	html = K('#new_message').val(); // KindEditor Node API
	html = $('#new_message').val(); // jQuery
	
	// 设置HTML内容
	editor.html('HTML内容');
	
	// 关闭过滤模式，保留所有标签
	KindEditor.options.filterMode = false;
	
	KindEditor.ready(function(K) {
	        K.create('#new_message');
	});
	</script>
	<!-- ---------结束设置kindeitor------------ -->	
</head>
<body>
<div id="wrapper">
    <!-- 导航栏部分  start-->
    <%@ include file="nav.jsp" %>
    <!-- 导航栏部分 end -->    
    <!-- 新闻列表查询部分  start-->
	<div id="page-wrapper">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">项目管理</h1>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-body">
				<form class="form-inline" method="post" action="${pageContext.request.contextPath}/admin/news/list.action">
					<div class="form-group">
						<label for="title">项目标题</label>
						<input type="text" class="form-control" id="title"  name="title" value="" />
					</div>
					<div class="form-group">
						<label for="newsColumnId">项目类别</label>
						<select	class="form-control" id="newsColumnId" name="newsColumnId">
							<option value="">--请选择--</option>	
							<c:forEach items="${newsColumnList}" var="newsColumn">
							 <option value="${newsColumn.newsColumnId}"
							  <c:if test="${newsColumn.newsColumnId==newsColumnId}">selected</c:if> >${newsColumn.columnName}			
							 </option>
							</c:forEach>	
						</select>
					</div>
					<button type="submit" class="btn btn-primary">查询</button>
				</form>
			</div>
		</div>
		<a href="#" class="btn btn-primary" data-toggle="modal" data-target="#addDialog" onclick="clearNews()" >新建</a>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">项目信息列表</div>
					<!-- /.panel-heading -->
					<table class="table table-bordered table-striped">
						<thead>
							<tr>
								<th>ID</th>
								<th>类别</th>
								<th>标题</th>
								<th>发布时间</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
                           <c:forEach items="${page.rows}" var="news">
                               <tr>
                                    <td>${news.newsId}</td>
<%--                                   (ID=${news.newsColumn.newsColumnId})--%>
                                    <td>${news.newsColumn.columnName}</td>
                                    <td>${news.title}</td>
                                    <td>${news.createTime}</td>
                                    <td>
     <a href ="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#viewDialog" onclick="viewNews(${news.newsId})" >查看</a>     
     <a href="${pageContext.request.contextPath}/webs/newsview.action?newsId=${news.newsId}" class="btn btn-success btn-xs"
     target="_blank">预览</a>
     <a href="#" class="btn btn-danger btn-xs" onclick="deleteNews(${news.newsId})">删除</a>                     
                                    </td>
                                </tr>
                           </c:forEach>
						</tbody>
					</table>
					<div class="col-md-12 text-right">
					   <gdkmtool:page url="${pageContext.request.contextPath}/admin/news/list.action" />
					</div>
					<!-- /.panel-body -->
				</div>
				<!-- /.panel -->
			</div>
			<!-- /.col-lg-12 -->
		</div>
	</div>
	<!-- 新闻列表查询部分  end-->
</div>

<!-- 创建新闻模态框 -->
<div class="modal fade" id="addDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content" style="width:820px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">新建项目信息</h4>
			</div>
			<form class="form-horizontal" id="add_form" method=post enctype="multipart/form-data" 
			    action="<%=basePath%>/admin/news/addNews.action"  onsubmit="return checkAddNews()" >			
			<div class="modal-body">
			    <%--<form class="form-horizontal" id="add_form" >				
					--%><div class="form-group">
						<label for="new_title" class="col-sm-2 control-label">项目标题</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" placeholder="项目标题" id="new_title" name="title" />
						</div>						
					</div>
					<div class="form-group">
						<label for="new_newsColumnId" class="col-sm-2 control-label">项目类别</label>
						<div class="col-sm-10">
							<select	class="form-control" id="new_newsColumn"  name="newsColumn">
							  <c:forEach items="${newsColumnList}" var="newsColumn">
							      <option value="${newsColumn.newsColumnId}">${newsColumn.columnName}</option>
							  </c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="new_message" class="col-sm-2 control-label">项目内容</label>
						<div class="col-sm-10">
							<textarea  id="new_message"  name="message" style="width:350px;height:500px;" ></textarea>
						</div>
					</div>					
					<div class="form-group">
						<label for="new_pic" class="col-sm-2 control-label">上传图片</label>
						<div class="col-sm-10">
							<input type="file" class="form-control" placeholder="上传图片" id="uploadfile" name="uploadfile" />
							<input type="hidden" id="new_pic_src" name="pic" value="" />
							<a href="#" onclick="uploadPic()">上传</a>							
						</div>
					</div>
				<%--</form>	--%>
			</div>		
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button type="submit" class="btn btn-primary" onclick="">提交</button>
			</div>
		</form>	
		</div>
	</div>
</div>

<!-- 查看项目模态框 -->
<div class="modal fade" id="viewDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content"  style="width:900px;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">查看项目信息</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" id="view_form">
				    <input type="hidden" id="view_newsId" name="newsId"/>
					<div class="form-group">
						<label for="view_title" class="col-sm-2 control-label">项目标题</label>
						<div class="col-sm-10">				
							<div style="vertical-align:middle;line-height:34px;" id="view_title" ></div>
						</div>						
					</div>
					<div class="form-group">
						<label for="view_newsColumn" class="col-sm-2 control-label">项目栏目</label>
						<div class="col-sm-10">				
							<div style="vertical-align:middle;line-height:34px;" id="view_newsColumn" ></div>
						</div>						
					</div>						
					<div class="form-group">
						<label for="view_createTime" class="col-sm-2 control-label">发布时间</label>
						<div class="col-sm-10">				
							<div style="vertical-align:middle;line-height:34px;" id="view_createTime" ></div>
						</div>						
					</div>	
					<div class="form-group">
						<label for="view_account" class="col-sm-2 control-label">项目作者</label>
						<div class="col-sm-10">				
							<div style="vertical-align:middle;line-height:34px;" id="view_account" ></div>
						</div>						
					</div>																				
					<div class="form-group">
						<label for="view_message" class="col-sm-2 control-label">项目详情</label>
						<div class="col-sm-10">
						     <div style="vertical-align:middle;height:500px;" id="view_message" ></div>  
						</div>
					</div>					
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
 //打开新建页面
 function clearNews(){
	 $("#new_title").val("");
	 $("#new_message").val("");
 }
 //检查项目菜单
 function checkAddNews(){
	 var title = document.getElementById("new_title").value;
	 var message = document.getElementById("new_message").value;
	 if(title==""){
		 alert("填写标题");
		 return false;
	 }
	 return true;
 }
 //单独上传图片
 function uploadPic(){
	 var formData = new FormData();
	 formData.append('uploadfile',$('#uploadfile')[0].files[0]);
	 $.ajax({
		 type:"post",
	     url:"<%=basePath%>/admin/fileUpload.action",
	     data:formData,
	     processData:false,
	     contentType:false,
	     cache:false,
	     success:function(data){
	    	 alert("上传成功！文件路径="+data);
	    	 $("new_pic_src").val(data);
	     }
	 });
 }
 //删除项目
 function deleteNews(newsId){
	 if(confirm('确实要删除该项目吗？')){
		 $.post("<%=basePath%>admin/news/delete.action",{"newsId":newsId},
				 function(data){
			 if(data == "OK"){
				 alert("删除项目成功！");
			 }else{
				 alert("删除项目失败！");
			 }
			 window.location.reload();
		 });
	 }
 }
 //查看项目
 function viewNews(newsId){
	 $.ajax({
		 type:"get",
	     url:"<%=basePath%>admin/news/view.action",
	     data:{"newsId":newsId},
	     success:function(data){
	    	 $("#view_newsId").val(data.newsId);
	    	 $("#view_title").text(data.title);
	    	 $("#view_createTime").text(data.createTime);
	    	 $("#view_account").text(data.account);
	    	 $("#view_newsColumn").text(data.newsColumn.columnName);
	    	 $("#view_message").html(data.message);
	     }
	 });
 }
 
 
</script>
</body>
</html>