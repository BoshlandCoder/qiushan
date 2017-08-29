<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
    <div class="wrap">
        <div class="logo" style="margin-left: 20px;"> <a href="forward.action?name=index"><img src="${pageContext.request.contextPath}/images/hiqs.jpg" alt=""/></a> </div>
        <div class="header-right">
			<ul>
				<li class='has-sub'><a href='forward.action?name=index'><span>首页</span></a></li>
				<li class='has-sub'><a href='about.html'><span>收藏</span></a></li>
				<%-- <li class='has-sub'><a href='index.html'><span>回忆</span></a></li>--%>
				<li class='has-sub'><a href='#'><span>消息</span></a></li>
				<s:if test="null==#session.user||#session.user.isEmpty()">
					<li class='has-sub'><a href='forward.action?name=login'><span>登录</span></a></li>
					<li class='has-sub'><a href='forward.action?name=regist'><span>注册</span></a></li>
				</s:if>
				<s:else>
					<li class='has-sub' style="float: right"><a href='forward.action?name=exit'><span>注销</span></a></li>
					<li class='' style="float: right;list-style: none;padding-top: 20px;" ><span>${sessionScope.user.username},你好</span></li>
				</s:else>
			</ul>
            <%--<div id='cssmenu'>

            </div>--%>
			<%--<div style="float: left;">
				<input  class="easyui-textbox" type="text" value="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Search';}">
			</div>--%>
        </div>
		<%--<div class="search_box">
			<form>
				&lt;%&ndash;<div id="search_img"><img src="images/qs.jpg" alt=""/></div>&ndash;%&gt;
				<input type="text" value="Search" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = 'Search';}">
				<input type="submit" value="">
			</form>
		</div>--%>
    </div>
</div>
</body>
</html>