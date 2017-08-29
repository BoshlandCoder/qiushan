/**
 * 
 */
$(function(){
	$('#tavernName').focus();
});
//验证用户名
function checkTavernName(){
	$("#tavernName").css("background-color", "#FFFFCC"); 
    var tavernname = $("#tavernName").val();  
    $("#tavernName").css("background-color", "white");  
    if (tavernname.length <= 0 ) { 
        $("#tavernNameError").show();  
        $('#tavernName').focus();
        return false;
    } else {  
        $("#tavernNameError").hide();  
        return true;
    } 
}
function checkBedCount(){
	 $("#bedcount").css("background-color", "#FFFFCC");
	 var bedcount = $("#bedcount").val();  
     $("#bedcount").css("background-color", "white"); 
     var regtitle = /^[0-9]*$/;
     if (bedcount.length > 0 ) { 
    	 if(regtitle.test(bedcount)){
    		 $("#bedcountError").html("");
    		 return true;
    	 }else{
    		 $("#bedcountError").html("请输入数字");
    		 $('#bedcount').focus();
    		 return false;
    	 }
     } else {  
         $("#bedcountError").html("床铺数量不能为空");  
         $('#bedcount').focus();
         return false;
     }
}
function checkHouseType(){
	var houseType = $("#housetype").val();  
	if(houseType.length>0){
		$('#housetypeError').html("");
		
		return true;
	}else{
		$('#housetypeError').html("房源类型不能为空");
		$('#housetype').focus();
		return false;
	}
}
//function checkIsHouse(){
//	var ishouse = $("#ishouse").val();  
//	if(ishouse.length>0){
//		$('#ishouseError').html("");
//		
//		return true;
//	}else{
//		$('#ishouseError').html("可住不能为空");
//		$("#ishouse").focus();
//		return false;
//	}
//}
function checkLocation(){
	$("#location").css("background-color", "#FFFFCC"); 
     var location = $("#location").val();  
     $("#location").css("background-color", "white");  
     if (location.length <= 0 ) {  
         $("#locationError").html("位置不能为空");  
         $("#location").focus();
         return false;
     } else {  
         $("#locationError").html("");  
         return true;
     }  
}
function checkPrice(){
	 $("#price").css("background-color", "#FFFFCC");
	 $("#price").css("background-color", "#FFFFCC");
	 var price = $("#price").val();  
     $("#price").css("background-color", "white"); 
     var regtitle = /^[0-9.]*$/;
     if (price.length > 0 ) { 
    	 if(regtitle.test(price)){
    		 $("#priceError").html("");
    		 return true;
    	 }else{
    		 $("#priceError").html("请输入数字");
    		 $("#price").focus();
    		 return false;
    	 }
     } else {  
         $("#priceError").html("价格不能为空");  
         $("#price").focus();
         return false;
     }
}

function check(){
	if(checkTavernName()&&
			checkBedCount()&&
			checkHouseType()&&
			checkLocation()&&
			checkPrice()){
		if($('#a').prop('checked')){
			return true;
		}else{
			alert("请先同意服务条款");
			return false;
		}
		
	}else{
		return false;
	}
	
	
	
}