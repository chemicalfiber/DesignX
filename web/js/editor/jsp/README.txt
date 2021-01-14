KindEditor JSP

本JSP程序是演示程序，建议不要直接在实际项目中使用。
如果您确定直接使用本程序，使用之前请仔细确认相关安全设置。
 
使用方法:

1. 解压zip文件，将所有文件复制到Tomcat的webapps/kindeditor目录下。

2. 将kindeditor/jsp/lib目录下的3个jar文件复制到Tomcat的lib目录下，并重新启动Tomcat。
	* commons-fileupload-1.2.1.jar
	* commons-io-1.4.jar
	* json_simple-1.1.jar

3. 打开浏览器，输入http://localhost:[P0RT]/kindeditor/jsp/demo.jsp。

------------------------------------------------------------

上传使用说明
upload_json.jsp页面负责上传图片

将源文件中
//文件保存目录路径
String savePath = pageContext.getServletContext().getRealPath("/") + "attached/";

//文件保存目录URL
String saveUrl  = request.getContextPath() + "/attached/";

修改为

//文件保存目录路径
String savePath = pageContext.getServletContext().getRealPath("/") + "upload/";

//文件保存目录URL
String saveUrl  = request.getContextPath() + "/upload/";

并在 upload下面新建 image文件夹  图片将 保存 到 该文件夹下
