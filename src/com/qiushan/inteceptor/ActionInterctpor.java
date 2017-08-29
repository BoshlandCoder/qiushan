package com.qiushan.inteceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ActionInterctpor extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		ActionContext actionContext=ActionContext.getContext();
		if(actionContext.getSession().get("user")!=null){
			return invocation.invoke();
		}else{
			actionContext.getSession().put("login", "ÇëÏÈµÇÂ¼");
			return "error";
		}
	}

}
