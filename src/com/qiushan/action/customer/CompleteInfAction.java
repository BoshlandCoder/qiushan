package com.qiushan.action.customer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.service.CustomerService;

public class CompleteInfAction extends  ActionSupport{
	private CustomerService customerService;
	private int user_id;
	private CustomerDetial customerDetial;
	private Integer flag;
	
	
	
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public CustomerDetial getCustomerDetial() {
		return customerDetial;
	}
	public void setCustomerDetial(CustomerDetial customerDetial) {
		this.customerDetial = customerDetial;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("进入完善信息");
		if(customerDetial.getAddress()!=null
				&&customerDetial.getEmail()!=null
				&&customerDetial.getIdcard()!=null
				&&customerDetial.getName()!=null
				&&customerDetial.getPhone()!=null
				&&customerDetial.getAge()!=null){
			customerDetial.setLevel(1);
			CustomerDetial customerDetial1 = customerService.completeInf(user_id, customerDetial,flag);
			if(customerDetial1!=null){
				System.out.println("完善信息成功");
				ActionContext.getContext().getSession().put("userDetial", customerDetial1);
				addActionMessage("completeInfSuccess");
				return "completeInfSuccess";
			}else{
				System.out.println("完善信息失败");
				addActionMessage("completeInfFail");
				return "completeInfFail";
			}
		}else{
			System.out.println("数据段有空");
			addActionMessage("fieldIsNull");
			return null;
		}
	}
	
}
