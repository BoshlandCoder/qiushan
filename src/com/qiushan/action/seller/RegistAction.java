package com.qiushan.action.seller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.service.SellerService;

public class RegistAction extends ActionSupport{
	private String username;
	private String password;
	private SellerService sellerService;
	private String code;
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public SellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("�����̼�ע��");
		System.out.println(username);
		System.out.println(password);
		System.out.println(code);
		if(ActionContext.getContext().getSession().get("random").equals(code)){
			if(sellerService.regist(username, password)){
				ActionContext.getContext().put("registSuccess", "��ϲ��ע��ɹ������¼");
				return "registSuccess";
			}else{
				addActionMessage("registFail");
				return "registFail";
			}
		}else{
			ActionContext.getContext().put("codeError", "��֤���������������ע��");
			return "codeError";
		}
	}
	
}
