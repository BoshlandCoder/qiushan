<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房源记录</title>
</head>
<body>
	<h1>房源记录</h1>
	<s:if test="null==#session.user||#session.user.isEmpty()">  
  		<font color="#855E03">您好</font>
  		 <s:a href="forward.action?name=login">请登录</s:a>  
    	以获取为您订制的推荐. 新客户?<s:a href="forward.action?name=regist">点这里注册</s:a>  
	</s:if>
	<s:elseif test="null==#session.houses && null==#session.newHouse">
		<font color="#855E03">您好，您还没有房源记录</font>
		<s:a href="forward.action?name=login">创建房源</s:a> 
	</s:elseif>
	<s:elseif test="null==#session.newHouse">
		房源信息
		<ul>
			<s:iterator value="#session.houses" status="st" var="house">
				<li><a href="sellerGetHouse.action?house_id=<s:property value="#house.id"/>">
					<s:property value="#house.name"/>
				</a></li>
			</s:iterator>
		</ul>
	</s:elseif>
	<s:else>
		房源信息
		<a href="sellerGetHouse.action?house_id=<s:property value="#session.newHouse.id"/>">
					<s:property value="#session.newHouse.name"/>
		</a>
	</s:else>
</body>
</html>