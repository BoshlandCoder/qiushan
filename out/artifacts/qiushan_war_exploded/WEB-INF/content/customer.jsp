<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
  <head>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pagecontext.request.contextPath}/qiushan/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>
	<title>个人资料</title>
  </head>
  
  <body class="easyui-layout">
  	<s:if test="null!=#request.completeInf">
  		<script type="text/javascript">
  			var completeInf = "${requestScope.completeInf}";
  			alert(completeInf);
  		</script>
  	</s:if>
   	<div region="north" title="" split="true" height=100px>
   		<jsp:include page="common/head1.jsp"/>
   	</div>
   	<div region="west" title="" split="false" style="width:200px; padding: 15px" >
   		<ul class="easyui-tree" style="background: #E3FBE3">
   			<li><span>用户资料</span>
	   			<ul>
	   				<li><span><a onclick="addTab('个人资料','forward.action?name=customerInf');">个人资料</a></span></li>
	   			</ul>
	   			<ul>
	   				<li><span><a onclick="addTab('资料修改','forward.action?name=customerCompleteInf');">资料修改</a></span></li>
	   			</ul>
   			</li>
   		</ul>
   	</div>
   	<div id="main" region="center" style="">
   		<div id="center_tab" class="easyui-tabs" border="false" fit="true" style="">
		</div>
   	</div>
  </body>
<script>  
  $(document).ready(function(){
  	
  });
  function addTab(title,url){
  	if($('#center_tab').tabs('exists',title) == true){ 
		$('#center_tab').tabs('select',title); 
		return updateTab();
	}
	$('#center_tab').tabs('add',{
		title:title,		
		content:'<iframe frameborder="0" scrolling="auto" style="width:100%;height:100%" src="'+url+'"></iframe>',
		closable:true,
		tools:[{
			iconCls:'icon-mini-refresh',
			handler:function(){	
				updateTab();
			}
		}]
	});
  }
  function updateTab(){
	var tab = $('#center_tab').tabs('getSelected');	
	$('#center_tab').tabs('update', {
		tab: tab,
		options:{
			//title:tab.panel('options').title
		}
	});		
}
</script> 
</html>
