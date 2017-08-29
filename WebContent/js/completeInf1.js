$(function(){
	$('#address').focus();
})
function checkAddress(){
	$("#address").css("background-color", "#FFFFCC");
    var address = $("#address").val();  
    $("#address").css("background-color", "white");  
    if (address.length <= 0) {   
        $("#addressError").html("请输入地址");  
        $('#address').focus();
        return false;
    } else {  
        $("#addressError").html("");  
        return true;
    }
}
function checkAge(){
	$("#age").css("background-color", "#FFFFCC");
	var regtitle = /^[0-9]*$/
	var age = $("#age").val();  
    $("#age").css("background-color", "white");  
    if (age.length > 0 ) {  
    	if(regtitle.test(age)){
    		$('#ageError').html("");
    		return true;
    	}else{
    		$("#ageError").html("输入不合法");
    		$("#age").focus();
    		return false;
    	}
          
    } else {  
        $("#ageError").html("请输入年龄");  
        $("#age").focus();
        return false;
    } 
}
function checkEmail(){
	 $("#email").css("background-color", "#FFFFCC"); 
	 var reg = /^([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\-|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/gi;  
     var email = $("#email").val();  
     $("#email").css("background-color", "white");  
     if (email.length > 0) {  
    	 if(reg.test(email)){
    		 $("#emailError").html("");
    		 return true;
    	 }else{
    		 $("#emailError").html("请输入正确的邮箱");
    		 $("#email").focus();
    		 return false;
    	 }
     }else{  
         $("#emailError").html("邮箱不能为空");  
         $("#email").focus();
		 return false;
     }    
}
function checkIdCard(){
	$("#idcard").css("background-color", "#FFFFCC"); 
	var idcard = $("#idcard").val();  
    $("#idcard").css("background-color", "white");  
    if(idcard.length>0){
    	if(IdCardValidate(idcard)){
        	$("#idcardError").html("");
        	return true;
        }else{
        	$("#idcardError").html("请输入正确的身份证");
        	$("#idcard").focus();
        	return false;
        }
    }else{
    	$("#idcardError").html("身份证不能为空");
    	$("#idcard").focus();
    	return false;
    }
}
/*
 * 
 * 验证身份证代码
 * 
 * */
var Wi = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1 ];// 加权因子   
var ValideCode = [ 1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2 ];// 身份证验证位值.10代表X   
function IdCardValidate(idCard) {   
    idCard = trim(idCard.replace(/ /g, ""));   
    if (idCard.length == 15) {   
        return isValidityBrithBy15IdCard(idCard);   
    } else if (idCard.length == 18) {   
        var a_idCard = idCard.split("");// 得到身份证数组   
        if(isValidityBrithBy18IdCard(idCard)&&isTrueValidateCodeBy18IdCard(a_idCard)){   
            return true;   
        }else {   
            return false;   
        }   
    } else {   
        return false;   
    }   
}   
/**  
 * 判断身份证号码为18位时最后的验证位是否正确  
 * @param a_idCard 身份证号码数组  
 * @return  
 */  
function isTrueValidateCodeBy18IdCard(a_idCard) {   
    var sum = 0; // 声明加权求和变量   
    if (a_idCard[17].toLowerCase() == 'x') {   
        a_idCard[17] = 10;// 将最后位为x的验证码替换为10方便后续操作   
    }   
    for ( var i = 0; i < 17; i++) {   
        sum += Wi[i] * a_idCard[i];// 加权求和   
    }   
    valCodePosition = sum % 11;// 得到验证码所位置   
    if (a_idCard[17] == ValideCode[valCodePosition]) {   
        return true;   
    } else {   
        return false;   
    }   
}   
/**  
 * 通过身份证判断是男是女  
 * @param idCard 15/18位身份证号码   
 * @return 'female'-女、'male'-男  
 */  
function maleOrFemalByIdCard(idCard){   
    idCard = trim(idCard.replace(/ /g, ""));// 对身份证号码做处理。包括字符间有空格。   
    if(idCard.length==15){   
        if(idCard.substring(14,15)%2==0){   
            return 'female';   
        }else{   
            return 'male';   
        }   
    }else if(idCard.length ==18){   
        if(idCard.substring(14,17)%2==0){   
            return 'female';   
        }else{   
            return 'male';   
        }   
    }else{   
        return null;   
    }   
//  可对传入字符直接当作数组来处理   
// if(idCard.length==15){   
// alert(idCard[13]);   
// if(idCard[13]%2==0){   
// return 'female';   
// }else{   
// return 'male';   
// }   
// }else if(idCard.length==18){   
// alert(idCard[16]);   
// if(idCard[16]%2==0){   
// return 'female';   
// }else{   
// return 'male';   
// }   
// }else{   
// return null;   
// }   
}   
 /**  
  * 验证18位数身份证号码中的生日是否是有效生日  
  * @param idCard 18位书身份证字符串  
  * @return  
  */  
function isValidityBrithBy18IdCard(idCard18){   
    var year =  idCard18.substring(6,10);   
    var month = idCard18.substring(10,12);   
    var day = idCard18.substring(12,14);   
    var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
    // 这里用getFullYear()获取年份，避免千年虫问题   
    if(temp_date.getFullYear()!=parseFloat(year)   
          ||temp_date.getMonth()!=parseFloat(month)-1   
          ||temp_date.getDate()!=parseFloat(day)){   
            return false;   
    }else{   
        return true;   
    }   
}   
  /**  
   * 验证15位数身份证号码中的生日是否是有效生日  
   * @param idCard15 15位书身份证字符串  
   * @return  
   */  
  function isValidityBrithBy15IdCard(idCard15){   
      var year =  idCard15.substring(6,8);   
      var month = idCard15.substring(8,10);   
      var day = idCard15.substring(10,12);   
      var temp_date = new Date(year,parseFloat(month)-1,parseFloat(day));   
      // 对于老身份证中的你年龄则不需考虑千年虫问题而使用getYear()方法   
      if(temp_date.getYear()!=parseFloat(year)   
              ||temp_date.getMonth()!=parseFloat(month)-1   
              ||temp_date.getDate()!=parseFloat(day)){   
                return false;   
        }else{   
            return true;   
        }   
  }   
//去掉字符串头尾空格   
function trim(str) {   
    return str.replace(/(^\s*)|(\s*$)/g, "");   
}
function checkPhone(){
	$("#phone").css("background-color", "#FFFFCC");
	var phone = $("#phone").val();  
    $("#phone").css("background-color", "white");
    var myreg = /^(((1[8537][0-9]{1})|159|153)+\d{8})$/;
    if(phone.length>0){
    	if(phone.length==11){
    		if(myreg.test(phone)){
    			$("#phoneError").html("");
    			return true;
    		}else{
    			$("#phoneError").html("请输入有效的手机号");
    			$("#phone").focus();
    			return false;
    		}
    	}else{
    		$("#phoneError").html("请输入有效的手机号");
    		$("#phone").focus();
			return false;
    	}
    }else{
    	$("#phoneError").html("请输入手机号");
    	$("#phone").focus();
		return false;
    }
}
function check(){
	if(checkAddress()&&checkAge()&&checkEmail()&&checkIdCard()&&checkPhone()){
		if($('#a').prop("checked")){
			return true;
		}else{
			alert("请先同意服务条款");
			return false;
		}
	}else{
		return false;
	}
}









