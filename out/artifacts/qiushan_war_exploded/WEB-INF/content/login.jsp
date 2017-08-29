<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="./css/register.css">
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
<style type="text/css">
	body{
		background-image: url(images/background.jpg);
	}
	.page-cont{
		margin-left: 35%;
		margin-top:50px;
	}
</style>
</head>
<body>
	
	<s:if test="null!=#request.codeError">
		<script type="text/javascript">
			var codeError="${requestScope.codeError}";
			alert(codeError);
		</script>
	</s:if>
	<s:if test="null!=#request.loginfail">
		<script type="text/javascript">
			var loginfail="${requestScope.loginfail}";
			alert(loginfail);
		</script>
	</s:if>
	<s:if test="null!=#request.registSuccess">
		<script type="text/javascript">
			var registSuccess="${requestScope.registSuccess}";
			alert(registSuccess);
		</script>
	</s:if>
	<% 
		request.getSession().removeAttribute("login");
	%>
    <div class="page-cont">
        <a href='loadgoods.action' style="position: absolute;top:10px; right: 15%">回到首页</a>
        <div class="main-box">
            <div class="login-btn-tabs login-btn-tabs-type">
                <a href="javascript:void(0)" class="active" id="way-one-main">普通会员登录</a>|<a href="javascript:void(0)" class="" id="way-two-main">商家登录</a>
            </div>

            <div class="m-from t-from">
                <div class="form-group">
                    <form id="registerForm" action="customerLogin.action" autocomplete="off" method="post" novalidate="novalidate">
                        <div class="control-group way-one">
                            <div class="controls" >
                                <label for="mobile" style="margin-left: 0;">
                                    <input id="mobile" name="username" type="text" maxlengt="11"  style="width: 300px;">
                                    <span class="mask-text sj" style="width: 300px;">请输入用户名</span>
                                </label>
                            </div>
                            <div class="verify-info sj" style="display:none">
                                <span >用户名已被占用</span>
                            </div>
                        </div>

                        <div class="control-group way-two" style="display: none">
                            <div class="controls">
                                <label for="userid" style="margin-left: 0;">
                                    <input id="userid" name="username" type="text"  maxlengt="11" style="width: 300px;">
                                    <span class="mask-text zh" style="width: 300px;">请输入用户名</span>
                                </label>
                            </div>
                            <div class="verify-info zh" style="display:none">
                                <span >用户名已被占用</span>
                            </div>
                        </div>


                        <div class="control-group">
                            <label for="" class="controls-label">登录密码</label>
                            <div class="controls">
                                <label for="password">                            
                                    <input id="password" name="password" type="password" autocomplete="off">
                                    <span class="mask-text mm">登录密码</span>
                                </label><i class="icon-eye"></i>
                            </div>
                            <div class="verify-info mm" style="display:none">
                                <span >密码请超过6位</span>
                            </div>
                        </div>

                        <div id="verifyImageContainer" class="control-group verify-group" style="display:block">
                            <label for="verifyCode" class="controls-label">验证码</label>
                            <div class="controls">
                                <label for="verifyCodePic">
                                    <input id="verifyCodePic" name="code" type="text" maxlength="6" autocomplete="off">
                                    <span class="mask-text yzm">请输入验证码</span>
                                </label>
                                <img id="verifyImage" alt="" class="verify-image" width="130" height="40" title="看不清，换一张" src="rand.action">
                            </div>
                            <div class="verify-info"></div>
                        </div>

                        <!--<div class="control-group">-->
                            <!--<label for="" class="controls-label">邮箱</label>-->
                            <!--<div class="controls">-->

                                <!--<label for="email">-->
                                    <!--<input id="email" name="email" type="text" value="">-->
                                    <!--<span class="mask-text yx">常用邮箱（可作为登录账号）</span>-->
                                <!--</label>-->
                            <!--</div>-->
                            <!---->
                            <!--<div class="verify-info" style="display:none">-->
                                <!--<span class="field-validation-valid" data-valmsg-for="Email" data-valmsg-replace="true"></span>-->
                            <!--</div>-->
                        <!--</div>-->

                        <div class="control-group text-group">
                            <label for="">
                                <input id="chkFW" type="checkbox" checked="checked">
                                <a href="#" target="_blank" class="link-btn">《网服务协议》</a>
                            </label>
                        </div>
                        <div class="control-group button-group">
                            <input id="registerSumbit" type="submit" value="登录" title="注册">
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </div>
    <div id="myDiv"></div>
<script>

    $("#way-two-main").click(function () {
        $(".way-two").css('display','block');
        $(".way-one").css('display','none');

        $("#way-one-main").toggleClass('active');
        $("#way-two-main").toggleClass('active');
        //商家
        $("#registerForm").attr('action','sellerLogin.action');

    })

    $("#way-one-main").click(function () {
        $(".way-one").css('display','block');
        $(".way-two").css('display','none');

        $("#way-one-main").toggleClass('active');
        $("#way-two-main").toggleClass('active');
		//个人
        $("#registerForm").attr('action','customerLogin.action');
    })

    $(".mask-text.zh").click(function () {
        $(".mask-text.zh").css('display','none');
    })
   /*  $("#userid").blur(function () {
        var userid = $("#userid").val();
        alert(userid);
        if( userid == ""){
            $(".mask-text.zh").css('display','block');
        }else{
            $.post("#",
                {
                   userid:userid
                },
                function(result){
                    alert("结果：" + result);
                    if(result=="false"){
                        $(".verify-info.zh").css('display','block');
                    }
                });
        }
    }) */

    $(".mask-text.sj").click(function () {
        $(".mask-text.sj").css('display','none');
    })
    /* $("#mobile").blur(function () {
        var mobile =  $("#mobile").val();
        alert(mobile);
        if( mobile ==""){
            $(".mask-text.sj").css('display','block');
        }else{
            $.post("#",
                {
                    mobile:mobile
                },
                function(result){
                    alert("结果：" + result);
                    if(result=="false"){
                        $(".verify-info.sj").css('display','block');
                    }
              });
        }
    }) */

    $(".mask-text.mm").click(function () {
        $(".mask-text.mm").css('display','none');
    })
    $("#password").blur(function () {
        var password = $("#password").val();
        if( password ==""){
            $(".mask-text.mm").css('display','block');
        }else {
            if(password.length<6){
                $(".verify-info.mm").css('display','block');
            }else{
                $(".verify-info.mm").css('display','none');
            }

        }
    })

    $(".mask-text.yx").click(function () {
        $(".mask-text.yx").css('display','none');
    })
    $("#email").blur(function () {
        if( $("#email").val()==""){
            $(".mask-text.yx").css('display','block');
        }
    })

    $(".mask-text.yzm").click(function () {
        $(".mask-text.yzm").css('display','none');
    })
    $("#verifyCodePic").blur(function () {
        if( $("#verifyCodePic").val()==""){
            $(".mask-text.yzm").css('display','block');
        }
    })


</script>

</body>
</html>