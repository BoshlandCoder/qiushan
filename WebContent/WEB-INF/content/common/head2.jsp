<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
    <div class="wrap">
        <div class="logo"> <a href="forward.action?name=index"><img src="${pageContext.request.contextPath}/images/hiqs.jpg" alt=""/></a> </div>
        <div class="header-right">
            <div id='cssmenu'>
                <ul>
                    <li><a href='forward.action?name=index'><span>首页</span></a></li>
                    |
                    <li class='has-sub'><a href='index.html'><span>回忆</span></a>
                        <ul>
                            <li class='has-sub'><a href='index.html'><span>Service 1</span></a></li>
                            <li class='has-sub'><a href='index.html'><span>Service 2</span></a></li>
                        </ul>
                    </li>
                    |
                    <li class='has-sub'><a href='#'><span>消息</span></a></li>
                    |
                    <s:if test="null==#session.user||#session.user.isEmpty()"> 
                     	<li class='has-sub'><a href='forward.action?name=login'><span>登录</span></a></li>
                     	|
                     	<li class='last'><a href='forward.action?name=regist'><span>注册</span></a></li>
	  				</s:if>
	  				<s:else>
	  					<li class='has-sub'><span>${sessionScope.user.username}</span></li>
	  					|
	  					<li class='last'><a href='forward.action?name=exit'><span>注销</span></a></li>
                   		|
                   		<li class='last'><a href='forward.action?name=customer'><span>查看个人信息</span></a></li>
	  				</s:else>
                </ul>
            </div>
        </div>

<!-- 连接加  ${pageContext.request.contextPath} -->

        <div class="clear"></div>
    </div>
</div>
</body>
</html>