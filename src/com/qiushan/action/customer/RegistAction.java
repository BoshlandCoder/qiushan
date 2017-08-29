package com.qiushan.action.customer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.dao.CustomerDao;
import com.qiushan.service.CustomerService;

public class RegistAction extends ActionSupport{
	private String username;
	private String password;
	private String code;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	private CustomerService customerService;
	
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
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
		System.out.println("�����û�ע��");
		System.out.println(username);
		System.out.println(password);
		System.out.println(code);
		if(ActionContext.getContext().getSession().get("random").equals(code)){
			if(customerService.regist(username, password)){
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
