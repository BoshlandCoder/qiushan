<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pagecontext.request.contextPath}/qiushan/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pagecontext.request.contextPath}/qiushan/css/housegoods.css"/>

</head>
<body>
	<jsp:include page="common/head.jsp"></jsp:include>
	<div class="title">
		<div class="title_left">
		
		</div>
		<div class="title_right">
			<div class="price">
				价格：${sessionScope.houseDetial.price}
			</div>
			<a href="payRequest.action?user_id=${sessionScope.user.id}&price=${sessionScope.houseDetial.price}&house_user=${sessionScope.houseDetial.houseuser_id}">立即订购</a>
			<a href="addCart.action?house_id=${sessionScope.houseDetial.id}&customer_id=${sessionScope.userDetial.id}">加入订单</a>
		</div>
	</div>
	<h3>房源图片展示</h3>
	<div class="house">
		<div class="image">
			<img alt="" src="uploadFiles/${sessionScope.houseDetial.houseuser_id}/${sessionScope.houseDetial.tp_1}">
			<img alt="" src="uploadFiles/${sessionScope.houseDetial.houseuser_id}/${sessionScope.houseDetial.tp_2}">
			<img alt="" src="uploadFiles/${sessionScope.houseDetial.houseuser_id}/${sessionScope.houseDetial.tp_3}">
			<img alt="" src="uploadFiles/${sessionScope.houseDetial.houseuser_id}/${sessionScope.houseDetial.tp_4}">
			<img alt="" src="uploadFiles/${sessionScope.houseDetial.houseuser_id}/${sessionScope.houseDetial.tp_5}">
			<img alt="" src="uploadFiles/${sessionScope.houseDetial.houseuser_id}/${sessionScope.houseDetial.tp_6}">
		</div>
	</div>
	<h3>房源描述</h3>
	<div class="describe">
		<li>房源姓名:<s:property value="#session.houseDetial.name"/></li>
			<li>房源类型:<s:property value="#session.houseDetial.housetype"/></li>
			<s:if test="#session.houseDetial.bedroom==false">
				<li>是否有卧室:否</li>
			</s:if>
			<s:else>
				<li>是否有卧室:是</li>
			</s:else>
			<li>床的数量:<s:property value="#session.houseDetial.bedcount"/></li>
			<s:if test="#session.houseDetial.breakfirst==false">
				<li>是否提供早餐:否</li>
			</s:if>
			<s:else>
				<li>是否提供早餐:是</li>
			</s:else>
			<s:if test="#session.houseDetial.cookroom==false">
				<li>是否有厨房:否</li>
			</s:if>
			<s:else>
				<li>是否有厨房:是</li>
			</s:else>
			<s:if test="#session.houseDetial.ishouse==false">
				<li>是否可住:否</li>
			</s:if>
			<s:else>
				<li>是否可住:是</li>
			</s:else>
			<s:if test="#session.houseDetial.ispet==false">
				<li>是否可带宠物:否</li>
			</s:if>
			<s:else>
				<li>是否可带宠物:是</li>
			</s:else>
			<s:if test="#session.houseDetial.wifi==false">
				<li>是否有WIFI:否</li>
			</s:if>
			<s:else>
				<li>是否有WIFI:是</li>
			</s:else>
			<s:if test="#session.houseDetial.workspace==false">
				<li>是否有工作区:否</li>
			</s:if>
			<s:else>
				<li>是否有工作区:是</li>
			</s:else>
			<s:if test="#session.houseDetial.washroom==false">
				<li>是否带有洗手间:否</li>
			</s:if>
			<s:else>
				<li>是否带有洗手间:是</li>
			</s:else>
			<li>位置:<s:property value="#session.houseDetial.location"/></li>
			<li>备注:<s:property value="#session.houseDetial.other"/></li>
	</div>
	<jsp:include page="common/foot.jsp"/>
</body>
</html>