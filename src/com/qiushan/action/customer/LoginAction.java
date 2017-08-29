package com.qiushan.action.customer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.Customer;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.bean.SellerDetial;
import com.qiushan.service.CustomerService;

public class LoginAction extends ActionSupport{
	private CustomerService customerService;
	private String username;
	private String password;
	private String code;
	private Integer user_id;

	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
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
		// TODO Auto-generated method stub
		System.out.println("进入用户登录");
		System.out.println(username);
		System.out.println(password);
		System.out.println(code);
		if(ActionContext.getContext().getSession().get("random").equals(code)){
			Customer customer=customerService.login(username, password);
			if(customer==null){
				ActionContext.getContext().put("loginfail", "用户名或密码错误请重新登录");
				return "loginFail";
			}else{
				user_id=customer.getId();
				CustomerDetial customerDetial = customer.getCustomerDetial();
				if(customerDetial!=null){
					ActionContext.getContext().getSession().put("userDetial", customerDetial);
					user_id=customerDetial.getId();
					System.out.println("用户详细id:"+customerDetial.getId()+"user_id:"+user_id);
					ActionContext.getContext().getSession().put("user", customer);
					addActionMessage("loginSuccess");
					return "loginSuccess";
				}else{
					ActionContext.getContext().getSession().put("user", customer);
					return "loginSuccess";
				}
			}
		}else{
			ActionContext.getContext().put("codeError", "验证码错误,请重新登录");
			return "codeError";
		}
	}
	
}
