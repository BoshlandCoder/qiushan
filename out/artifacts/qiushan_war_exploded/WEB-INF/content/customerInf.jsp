<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户信息</title>
</head>
<body>
<s:if test="null==#session.user||#session.user.isEmpty()">  
  <font color="#855E03">您好</font> <s:a href="forward.action?name=login">请登录</s:a>  
    以获取为您订制的推荐. 新客户?<s:a href="forward.action?name=regist">点这里注册</s:a>  
</s:if>  
<s:elseif test="null==#session.userDetial||#session.userDetial.isEmpty()">
	<font color="#855E03">您好</font> <s:a href="forward.action?name=customerCompleteInf">请先完善个人信息</s:a>  
   	 以获取为您订制的推荐. 新客户?<s:a href="forward.action?name=regist">点这里注册</s:a>  
</s:elseif> 
<s:else>
	<ul>
		<li>用户名:${sessionScope.user.username }</li>
		<li>
			<s:if test="#session.userDetial.sex=='0'">性别:男</s:if>
			<s:else>性别:女</s:else>
		</li>
		<li>年龄:${sessionScope.userDetial.age }</li>
		<li>身份证号:${sessionScope.userDetial.idcard }</li>
		<li>真实姓名:${sessionScope.userDetial.name }</li>
		<li>联系方式:${sessionScope.userDetial.phone }</li>
		<li>邮箱:${sessionScope.userDetial.email }</li>
		<li>地址:${sessionScope.userDetial.address }</li>
	</ul>
</s:else>
</body>
</html>