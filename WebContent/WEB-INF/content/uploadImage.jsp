<%@ page language="java" contentType="text/html"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html">
<title>表单提交</title>
</head>
<body>
	<h2>上传图片</h2>
	<form action="sellerUpload.action?user_id=${user.id}" enctype="multipart/form-data" method="post">
		<ul>
			<li>选择文件<input type="file" name="image"/></li>
			<li>选择文件<input type="file" name="image"/></li>
			<li>选择文件<input type="file" name="image"/></li>
			<li>选择文件<input type="file" name="image"/></li>
			<li>选择文件<input type="file" name="image"/></li>
			<li>选择文件<input type="file" name="image"/></li>
		</ul><br>
		<input type="submit" value="提交"/>
	</form>
</body>
</html>