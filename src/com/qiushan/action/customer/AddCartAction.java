package com.qiushan.action.customer;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.service.CustomerService;

public class AddCartAction extends  ActionSupport{
	private Integer customer_id;
	private Integer house_id;
	private CustomerService customerService;
	
	
	public Integer getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}


	public Integer getHouse_id() {
		return house_id;
	}


	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("添加购物车");
		System.out.println(house_id);
		if(customer_id==null){
			ActionContext.getContext().put("completeInf", "请先完善个人信息");
			return "completeInf";
		}
		boolean flag = customerService.addCart(customer_id, house_id);
		if(flag){
			addActionMessage("addCartSuccess");
			return "addCartSuccess";
		}else{
			addActionMessage("addCartFail");
			System.out.println("添加购物车失败 ");
			return "null";
		
		}
	}
}
