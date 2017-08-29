<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	if(request.getSession().getAttribute("user")!=null){
		session.removeAttribute("user");
		session.removeAttribute("userDetial");
		session.removeAttribute("houses");
		session.removeAttribute("random");
		session.removeAttribute("houseDetial");
		session.removeAttribute("allhouse");
		session.removeAttribute("newHouse");
		session.removeAttribute("cartids");
		
	
		
		response.sendRedirect("forward.action?name=index");
	}else{
		response.sendRedirect("forward.action?name=login");
	}
%>
