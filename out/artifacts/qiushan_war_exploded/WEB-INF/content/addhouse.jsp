<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>创建门店</title>
    <link href="./css/business.css" rel="stylesheet" type="text/css">
    <script src="js/jquery-3.2.1.js" type="text/javascript"></script>
    <script src="js/house.js" type="text/javascript"></script>
</head>

<body class="zh-CN">
${pagecontext.request.contextPath}
<div class="header">
    <div class="wrap-lg">
        <div class="top-info">
            <a href="#" class="i-user">用户名</a>
            <a href="#" class="i-lGuide">房东指引</a>
        </div>
    </div>
</div>

<div style="clear: left"></div>
<div id="wrapper" class="body wrap-lg">
    <div class="" id="mainContent">
        <div class="wrapper">
            <form id="mainForm" class="body wrap-lg" method="post" action="sellerAddHouse.action?user_id=${user.id}" enctype="multipart/form-data" onsubmit="return check()">
                <div class="detailWrapper">
                    <div class="titleBar">取一个有趣的名字</div>
                    <div class="rowsWrapper">
                        <div class="rowItem">
                            <div class="promptWrapper">
                                <input id="tavernName" name="house.name" class="input-w400" type="text" placeholder="like:总统VIP套房" aria-required="true" onblur="checkTavernName()"><label id="tavernNameError" class="textWarning" for="tavernName" style="display: none">名称不能为空</label>
                            </div>
                            <p class="textWarning"></p>
                        </div>
                    </div>

                    <!--分割线-->
                    <div class="solidLine"></div>
                    <div class="titleBar">设置您的基本信息 </div>
                    <p class="textMuted">我们非常重视隐私。您提供的基本信息会受到我们的严格保密。</p>
                    <div class="rowsWrapper" display="block">
                        <div class="rowItem">
                            <span class="labelName">床铺数量</span>
                            <input id="bedcount" name="house.bedcount" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkBedCount()">
                            <label id="bedcountError" class="textWarning" for="bedcount"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">卧室</span>
                            无<input id="bedroom_0" name="house.bedroom" type="radio" value="false"> 有<input id="bedroom_1" name="house.bedroom" type="radio" value="true" checked="checked">
                            <label id="bedroom-error" class="textWarning" for="bedroom" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">早餐</span>
                            无<input id="breakfast_0" name="house.breakfast" type="radio" value="false"> 有<input id="breakfast_1" name="house.breakfast" type="radio" value="true" checked="checked">
                            <label id="breakfast-error" class="textWarning" for="breakfast" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">厨房</span>
                            无<input id="cookroom_0" name="house.cookroom" type="radio" value="false" checked="checked"> 有<input id="cookroom_1" name="house.cookroom" type="radio" value="true">
                            <label id="cookroom-error" class="textWarning" for="cookroom" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">房源类型</span>
                            <input id="housetype" name="house.housetype" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkHouseType()">
                            <label id="housetypeError" class="textWarning" for="housetype"></label>
                            <p class="textWarning"></p>
                        </div>

                       <div class="rowItem">
                            <span class="labelName">可住</span>
                            	可住<input id="ishouse" name="house.ishouse" type="radio" > 不可住<input id="ishouse" name="house.ishouse" type="radio" value="true">
                            <label id="ishouse-error" class="textWarning" for="ishouse" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">是否圈养宠物</span>
                            无<input id="ispet_0" name="house.ispet" type="radio" value="false" checked="checked"> 有<input id="ispet_1" name="house.ispet" type="radio" value="true">
                            <label id="ispet-error" class="textWarning" for="ispet" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">位置</span>
                            <input id="location" name="house.location" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkLocation()">
                            <label id="locationError" class="textWarning" for="location" ></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">备注</span>
                            <input id="other" name="house.other" class="input-w200" type="text" aria-required="true" aria-invalid="false">
                            <label id="other-error" class="textWarning" for="other" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                        <span class="labelName">价格</span>
                        <input id="price" name="house.price" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkPrice()">
                        <label id="priceError" class="textWarning" for="price"></label>
                        <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">种类</span>
                            <input id="type" name="house.type" class="input-w200" type="text" aria-required="true" aria-invalid="false" onblur="checkType()"
                            
                            >
                            <label id="typeError" class="textWarning" for="type" ></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">无线网络</span>
                            无<input id="wifi_0" name="house.wifi" type="radio" value="fasle"> 有<input id="wifi_1" name="house.wifi" type="radio" value="true" checked="checked">
                            <label id="wifi-error" class="textWarning" for="wifi" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>
                        <div class="rowItem">
                            <span class="labelName">书桌工作区</span>
                            无<input id="workspace_0" name="house.workspace" type="radio" value="false"> 有<input id="workspace_1" name="house.workspace" type="radio" value="true" checked="checked">
                            <label id="workspace-error" class="textWarning" for="workspace" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>

                        <div class="rowItem">
                            <span class="labelName">卫生间</span>
                            无<input id="wrashroom_0" name="house.wrashroom" type="radio" value="false"> 有<input id="wrashroom_1" name="house.wrashroom" type="radio" value="true" checked="checked">
                            <label id="wrashroom-error" class="textWarning" for="wrashroom" style="display: none;"></label>
                            <p class="textWarning"></p>
                        </div>
                    <div class="terms" id="agreement">
                        <label style="cursor:pointer;"><input type="checkbox" id="a">我已阅读并同意遵守协议内容</label>
                        <span id="china-agreement">
                    	<a href="#" class="text-standOut" target="_blank"> 《QS商户服务协议》 &nbsp;</a>
                    	<a href="#" class="text-standOut ml10" target="_blank">  《QS商家入驻标准》 &nbsp;</a>
                    	<a href="#" class="text-standOut ml10" target="_blank"> 《QS预订服务条款》 &nbsp;</a>
                    </div>
                </div>

                <div class="detailSubmit">
                    <input type="submit" id="submit" value="提交">
                </div>
               </div>
            </form>
        </div>
    </div>
</div>
<script>
    $("#applySubmit").click(function(){
        //$("#submit").click();
        alert("提交");
        $("#mainForm").submit();
    })


</script>
</body>
</html>