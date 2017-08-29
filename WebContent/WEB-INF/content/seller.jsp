<%@page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
	<%--<link rel="stylesheet" type="text/css" href="/EasyUI-1.5.1/themes/insdep/easyui222.css">
	<link rel="stylesheet" type="text/css" href="${pagecontext.request.contextPath}/css/style.css"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/themes/icon.css">
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/js/locale/easyui-lang-zh_CN.js"></script>--%>
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
	<title>商家主页</title>
  </head>
  
  <body class="easyui-layout">
   	<div region="north" title="" split="false" style="height:60px">
   		<jsp:include page="common/head1.jsp"/>
   	</div>
   	<div region="west" title="" split="false" style="width:200px; padding: 15px" >
   		<ul class="easyui-tree">
   			<li><span>商家资料</span>
	   			<ul>
	   				<li><span><a onclick="addTab('个人资料','forward.action?name=sellerInf');">个人资料</a></span></li>
	   			</ul>
	   			<ul>
	   				<li><span><a onclick="addTab('资料修改','forward.action?name=sellerCompleteInf');">资料修改</a></span></li>
	   			</ul>
   			</li>
   		</ul>
   		<ul class="easyui-tree">
   			<li><span>订单管理</span>
	   			<ul>
	   				<li><span><a onclick="addTab('房源上传','forward.action?name=addhouse');">房源上传</a></span></li>
	   			</ul>
	   			<ul>
	   				<li><span><a onclick="addTab('房源','forward.action?name=showhouse');">房源</a></span></li>
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
