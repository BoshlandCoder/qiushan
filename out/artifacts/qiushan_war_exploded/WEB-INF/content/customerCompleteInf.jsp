<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>完善个人信息</title>
<link href="./css/business.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
<script src="js/completeInf1.js" type="text/javascript"></script>
<style type="text/css">
	body{
		background: #E3FBE3;
	}
</style>
</head>
<body class="zh-CN">
<!-- <div class="header">
    <div class="wrap-lg">
        <div class="top-info">
            <a href="#" class="i-user">用户名</a>
            <a href="#" class="i-lGuide">房东指引</a>
        </div>
    </div>
</div> -->

<div style="clear: left"></div>
<div id="wrapper" class="body wrap-lg">
    <div class="" id="mainContent">
        <div class="wrapper">
			<s:if test="null==#session.user||#session.user.isEmpty()">  
  			<font color="#855E03">您好</font> <s:a href="forward.action?name=login">请登录</s:a>  
    				以获取为您订制的推荐. 新客户?<s:a href="forward.action?name=regist">点这里注册</s:a>  
			</s:if>
			<s:elseif test="null==#session.userDetial||#session.userDetial.isEmpty()">
				<form id="mainForm" class="body wrap-lg" method="post" action="customerCompleteInf.action?user_id=${user.id}&flag=0" onsubmit="return check()">
                <div class="detailWrapper">
                    <div class="solidLine"></div>
                    <div class="titleBar">设置您的资质信息</div>
                    <p class="textMuted">上传资质信息，建立我们和住户对您的信任。</p>
                    <div class="rowsWrapper" display="block">
                        <div class="rowItem">
                            <span class="labelName">地址</span>
                            <input id="address" name="customerDetial.address" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkAddress()">
                            <label id="addressError" class="textWarning" for="address"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">年龄</span>
                            <input id="age" name="customerDetial.age" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkAge()">
                            <label id="ageError" class="textWarning" for="age"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">邮箱</span>
                            <input id="email" name="customerDetial.email" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkEmail()">
                            <label id="emailError" class="textWarning" for="email"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">身份证号</span>
                            <input id="idcard" name="customerDetial.idcard" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkIdCard()">
                            <label id="idcardError" class="textWarning" for="idcard"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">真实姓名</span>
                            <input id="name" name="customerDetial.name" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false">
                            <label id="name-error" class="textWarning" for="name" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">联系人电话</span>
                            <input id="phone" name="customerDetial.phone" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkPhone()">
                            <label id="phoneError" class="textWarning" for="phone"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">性别</span>
                            男<input id="sex_0" name="customerDetial.sex" type="radio" value="0"> 女<input id="sex_1" name="sex" type="radio" value="1" checked="checked">
                            <label id="sexError" class="textWarning" for="sex" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>
                        <!--<div class="rowItem">-->
                            <!--<span class="labelName">ID</span>-->
                            <!--<input id="uid" name="uid" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false">-->
                            <!--<label id="uid-error" class="textWarning" for="uid" style="display: none;"></label>-->
                            <!--<p class="textWarning"></p>-->
                        <!--</div>-->


                    </div>

                    <div class="terms" id="agreement">
                        <label style="cursor:pointer;"><input id="a" name="agreement-check" type="checkbox" class="valid" aria-invalid="false">我已阅读并同意遵守协议内容</label>
                        <span id="chinaAgreement">
                    	<a href="#" class="text-standOut" target="_blank"> 《QS商户服务协议》 &nbsp;</a>
                    	<a href="#" class="text-standOut ml10" target="_blank">  《QS商家入驻标准》 &nbsp;</a>
                    	<a href="#" class="text-standOut ml10" target="_blank"> 《QS预订服务条款》 &nbsp;</a>
                    </div>
                </div>

                <div class="detailSubmit">
                    <input type="submit"  id="submit_1" value="提交"/>
                    <a id="applySubmit" class="btn-primary-m" style="display:block">同意条款并提交</a>
                    <a id="disApplySubmit" class="btn-disable-m" style="display:block">同意条款并提交</a>
                </div>
            </form>
			</s:elseif>
            <s:else>
            	<form id="mainForm" class="body wrap-lg" method="post" action="sellerCompleteInf.action?user_id=${sessionScope.userDetial.id}&flag=1" onsubmit="return check()">
                <div class="detailWrapper">
                    <div class="solidLine"></div>
                    <div class="titleBar">设置您的资质信息</div>
                    <p class="textMuted">上传资质信息，建立我们和住户对您的信任。</p>
                    <div class="rowsWrapper" display="block">
                        <div class="rowItem">
                            <span class="labelName">地址</span>
                            <input id="address" name="sellerDetial.address" class="input-w200" type="text" aria-required="true" aria-invalid="false" value="${sessionScope.userDetial.address }" onblur="checkAddress()">
                            <label id="addressError" class="textWarning" for="address"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">年龄</span>
                            <input id="age" name="sellerDetial.age" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" value="${sessionScope.userDetial.age }" onblur="checkAge()">
                            <label id="ageError" class="textWarning" for="age"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">邮箱</span>
                            <input id="email" name="sellerDetial.email" class="input-w200" type="text" aria-required="true" aria-invalid="false" value="${sessionScope.userDetial.email }" onblur="checkEmail()">
                            <label id="emailError" class="textWarning" for="email"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">身份证号</span>
                            <input id="idcard" name="sellerDetial.idcard" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" value="${sessionScope.userDetial.idcard }" onblur="checkIdCard()">
                            <label id="idcardError" class="textWarning" for="idcard"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">真实姓名</span>
                            <input id="name" name="sellerDetial.name" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" value="${sessionScope.userDetial.name }">
                            <label id="name-error" class="textWarning" for="name" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">联系人电话</span>
                            <input id="phone" name="sellerDetial.phone" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false" value="${sessionScope.userDetial.phone }" onblur="checkPhone()">
                            <label id="phoneError" class="textWarning" for="phone"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">性别</span>
                            男<input id="sex_0" name="sellerDetial.sex" type="radio" value="0" checked="checked"> 女<input id="sex_1" name="sex" type="radio" value="1" value="${sessionScope.userDetial.sex }">
                            <label id="sex-error" class="textWarning" for="sex" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>
                        <!--<div class="rowItem">-->
                            <!--<span class="labelName">ID</span>-->
                            <!--<input id="uid" name="uid" maxlength="20" class="input-w200" type="text" aria-required="true" aria-invalid="false">-->
                            <!--<label id="uid-error" class="textWarning" for="uid" style="display: none;"></label>-->
                            <!--<p class="textWarning"></p>-->
                        <!--</div>-->


                    </div>

                    <div class="terms" id="agreement">
                        <label style="cursor:pointer;"><input id="a" type="checkbox">我已阅读并同意遵守协议内容</label>
                        <span id="china-agreement">
                    	<a href="#" class="text-standOut" target="_blank"> 《QS商户服务协议》 &nbsp;</a>
                    	<a href="#" class="text-standOut ml10" target="_blank">  《QS商家入驻标准》 &nbsp;</a>
                    	<a href="#" class="text-standOut ml10" target="_blank"> 《QS预订服务条款》 &nbsp;</a>
                    </div>
                </div>

                <div class="detailSubmit">
                    <input type="submit" id="submit" value="提交">
                    <a id="applySubmit" class="btn-primary-m" style="display:block">同意条款并提交</a>
                    <a id="disApplySubmit" class="btn-disable-m" style="display:block">同意条款并提交</a>
                </div>
            </form>
            </s:else>
        </div>
    </div>
</div>
<script>
    $("#applySubmit").click(function(){
        //$("#submit").click();
        //alert("提交");
        $("#mainForm").submit();
    })


</script>
</body>
</html>