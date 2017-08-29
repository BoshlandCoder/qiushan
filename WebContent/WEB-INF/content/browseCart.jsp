<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pagecontext.request.contextPath}/qiushan/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pagecontext.request.contextPath}/qiushan/css/browseCart.css"/>
</head>
<body>
	<jsp:include page="common/head2.jsp"/>
	<div class="bc_core">
		<s:if test="null==#session.orderhouses">
			<script type="text/javascript">
				alert("您还没有");
			</script>
		</s:if>
		<s:else>
			<s:iterator value="#session.orderhouses" var="house" status="st">
				<li>
					<a href="housegoods.action?house_id=<s:property value='#house.house.id'/>&sellerDetial_id=<s:property value='#house.house.houseuser_id'/>"><s:property value="#house.house.name"/></a>
					<span><a href="payRequest.action">立即购买</a></span>
					<span><a href="removeCart.action?user_id=<s:property value='#house.house.houseuser_id'/>&cart_id=<s:property value='#house.user_id'/>">删除订单</a></span>
				</li>
			</s:iterator>

			
		</s:else>
	</div>
	<jsp:include page="common/foot.jsp"/>
</body>
</html>