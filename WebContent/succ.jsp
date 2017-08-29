<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>图片上传成功</title>
</head>
<body>
	<script type="text/javascript">
		alert("图片上传成功");
	</script>
	<% 
		response.sendRedirect("forward.action?name=customerInf");
	%>
</body>
</html>