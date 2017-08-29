<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
	<link rel="stylesheet" type="text/css" href="/css/index.css"/>
	<link rel="stylesheet" type="text/css" href="/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="/EasyUI-1.5.1/themes/insdep/easyui222.css">
	<link rel="stylesheet" type="text/css" href="/EasyUI-1.5.1/themes/insdep/icon.css">
	<script type="text/javascript" src="/EasyUI-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script type="text/javascript" src="/js/form2js.js"></script>

	<script type="text/javascript" src="/js/json2.js"></script>
	<script type="text/javascript" src="/js/jquery.easyui-1.5.1.min.js"></script>
	<script type="text/javascript" src="/js/easyui-lang-zh_CN.js"></script>
</head>
<style>

	.left-btn {
		position: absolute;
		width: 45px;
		height: 45px;
		top: 248px;
		left: 47px;
		background:url("/images/icons.png") no-repeat 0 0;
		cursor: pointer;
	}
	.right-btn {
		position: absolute;
		width: 45px;
		height: 45px;
		top: 248px;
		right: 47px;
		background:url("/images/icons.png") no-repeat 0 -45px;
		cursor: pointer;
	}
</style>
<body>
<jsp:include page="common/head.jsp"/>
<%--<div class="header_d">

</div>--%>

<div class="" style="background-color: #ECEDF1;padding-top: 60px;width: 100%;overflow-y: auto">

	<div class="blick-style" style="height: 400px;">
		<span class="left-btn" onclick="changeCount(this)"></span>
		<div style="text-align: center">
			<img class="slider-img" src="/images/img_1.jpg" style="width: 88%" height="100%" alt="">
		</div>
		<span class="right-btn" onclick="changeCount(this)"></span>

		<%--<div style="display: inline-block;margin-left: 20px; margin-top: 10px;">
			<img src="images/qs.jpg" style="height:80px; width: 80px;display: inline-block;vertical-align: middle" alt=""/>
		</div>
		<div style="display: inline-block;margin-left: 100px;">
			<input type="text" class="easyui-searchbox" style="width: 600px;" data-options="height:30" />
		</div>--%>
	</div>

	<form class="blick-style" style="height: 62px;">

		<div class="search-div">
			<span>地址：</span>
			<select  class="easyui-combobox" style="width:160px;" data-options="editable:false,height:30">
				<option value="100">-=请选择=-</option>
			</select>
			<select  class="easyui-combobox" style="width:160px;" data-options="editable:false,height:30">
			</select>
			<select  class="easyui-combobox" style="width:167px;" data-options="editable:false,height:30">
			</select>
		</div>
		<div class="search-div">
			<span>时间</span>
			<input type="text" class="easyui-datebox" style="width:160px; height: 30px;">
			<input type="text" class="easyui-datebox" style="width:160px; height: 30px;">
		</div>
		<div class="search-div">
			<span>所需客房人数:</span>
			<input type="text" class="easyui-numberbox" style="width:160px; height: 30px;">
		</div>
		<button class="button-btn" type="button" style="margin-top: 0px;margin-left: 50px;" onclick="">查询</button>
		<%--<tr>
			<td >地址：</td>
			<td >
				<select  class="easyui-combobox" style="width:150px;height:25px" data-options="editable:false">
					<option value="100">-=请选择=-</option>
				</select>
				<select  class="easyui-combobox" style="width:150px;height:25px" data-options="editable:false">
				</select>
				<select  class="easyui-textbox" style="width:187px;height:25px" data-options="editable:false">
				</select>
			</td>
		</tr>
		<td >选择日期：</td>
		<td>
			<select class="easyui-datetimebox" style="width:140px;height:25px" data-options="editable:true">
			</select>
		</td>--%>
	</form>

	<div class="blick-style" style="height:800px">

	</div>




</div>
<%--<div class="bottom">
     <div class="bottom_img">
     	<ul>
     		<s:iterator value="#session.allhouse" var="house" status="st">
     			<li>
     				<a href="housegoods.action?house_id=<s:property value='#house.id'/>&sellerDetial_id=<s:property value='#house.houseuser_id'/>"> <img  height="250" width="350" src="uploadFiles/<s:property value='#house.houseuser_id'/>/<s:property value='#house.tp_1'/>"></a>
     			</li>
     	</s:iterator>
     	</ul>
 	 </div>
</div>--%>
<div class="index_bottom" style="">
	<jsp:include page="common/foot.jsp"/>
</div>

<script>

	var count = 1;

	function changeCount(obj) {
		var spanClass = $(obj).attr("class");
		if (spanClass == "left-btn") {
			if (count == 1) {
				count = 2;
			} else {
				count -= 1;
			}
		} else {
			if (count == 2) {
				count = 1;
			} else {
				count += 1;
			}
		}
		$(".slider-img").attr("src","/images/img_"+count+".jpg");
	}


</script>

</body>
</html>