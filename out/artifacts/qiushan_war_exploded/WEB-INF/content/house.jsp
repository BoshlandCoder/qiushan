<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>房源信息</title>
</head>
<body>
	<h1>房源详细信息</h1>
	<s:if test="null=#session.newHouse">
		<ul>
		<s:iterator value="#session.houses" var="house" status="st">
		<s:if test="#house.id==#request.house_id">
			<li>房源姓名:<s:property value="#house.name"/></li>
			<li>房源类型:<s:property value="#house.housetype"/></li>
			<s:if test="#house.bedroom==false">
				<li>是否有卧室:否</li>
			</s:if>
			<s:else>
				<li>是否有卧室:是</li>
			</s:else>
			<li>床的数量:<s:property value="#house.bedcount"/></li>
			<s:if test="#house.breakfirst==false">
				<li>是否提供早餐:否</li>
			</s:if>
			<s:else>
				<li>是否提供早餐:是</li>
			</s:else>
			<s:if test="#house.cookroom==false">
				<li>是否有厨房:否</li>
			</s:if>
			<s:else>
				<li>是否有厨房:是</li>
			</s:else>
			<s:if test="#house.ishouse==false">
				<li>是否可住:否</li>
			</s:if>
			<s:else>
				<li>是否可住:是</li>
			</s:else>
			<s:if test="#house.ispet==false">
				<li>是否可带宠物:否</li>
			</s:if>
			<s:else>
				<li>是否可带宠物:是</li>
			</s:else>
			<s:if test="#house.wifi==false">
				<li>是否有WIFI:否</li>
			</s:if>
			<s:else>
				<li>是否有WIFI:是</li>
			</s:else>
			<s:if test="#house.workspace==false">
				<li>是否有工作区:否</li>
			</s:if>
			<s:else>
				<li>是否有工作区:是</li>
			</s:else>
			<s:if test="#house.washroom==false">
				<li>是否带有洗手间:否</li>
			</s:if>
			<s:else>
				<li>是否带有洗手间:是</li>
			</s:else>
			<li>位置:<s:property value="#house.location"/></li>
			<li>备注:<s:property value="#house.other"/></li>
		</s:if>
	</s:iterator>
	</ul>
	</s:if>
	<s:else>
		<ul>
			<li>房源类型:<s:property value="#session.newHouse.housetype"/></li>
			<s:if test="#session.newHouse.bedroom==false">
				<li>是否有卧室:否</li>
			</s:if>
			<s:else>
				<li>是否有卧室:是</li>
			</s:else>
			<li>床的数量:<s:property value="#house.bedcount"/></li>
			<s:if test="#session.newHouse.breakfirst==false">
				<li>是否提供早餐:否</li>
			</s:if>
			<s:else>
				<li>是否提供早餐:是</li>
			</s:else>
			<s:if test="#session.newHouse.cookroom==false">
				<li>是否有厨房:否</li>
			</s:if>
			<s:else>
				<li>是否有厨房:是</li>
			</s:else>
			<s:if test="#session.newHouse.ishouse==false">
				<li>是否可住:否</li>
			</s:if>
			<s:else>
				<li>是否可住:是</li>
			</s:else>
			<s:if test="#session.newHouse.ispet==false">
				<li>是否可带宠物:否</li>
			</s:if>
			<s:else>
				<li>是否可带宠物:是</li>
			</s:else>
			<s:if test="#session.newHouse.wifi==false">
				<li>是否有WIFI:否</li>
			</s:if>
			<s:else>
				<li>是否有WIFI:是</li>
			</s:else>
			<s:if test="#session.newHouse.workspace==false">
				<li>是否有工作区:否</li>
			</s:if>
			<s:else>
				<li>是否有工作区:是</li>
			</s:else>
			<s:if test="#session.newHouse.washroom==false">
				<li>是否带有洗手间:否</li>
			</s:if>
			<s:else>
				<li>是否带有洗手间:是</li>
			</s:else>
			<li>位置:<s:property value="#session.newHouse.location"/></li>
			<li>备注:<s:property value="#session.newHouse.other"/></li>
		</ul>
	</s:else>
	
</body>
</html>