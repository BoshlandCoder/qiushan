package com.qiushan.action.customer;

import javax.annotation.Resource;

import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.service.CustomerService;

public class RemoveCartAction extends  ActionSupport{
	private int cart_id;
	private int user_id;
	//private CustomerService customerService;
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	@Resource
	private CustomerService customerService;
	
	/*public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}*/
	public String execute() throws Exception {
		System.out.println("删除订单");
		System.out.println("用户id"+user_id);
		System.out.println("购物车"+cart_id);
		if(customerService.removeCart(user_id, cart_id)){
			addActionMessage("removeCartSuccess");
			return "removeCartSuccess";
		}else{
			addActionMessage("removeCartFail");
			return null;
		}
	}
}
