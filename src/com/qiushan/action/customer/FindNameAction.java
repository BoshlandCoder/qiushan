package com.qiushan.action.customer;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.service.CustomerService;

public class FindNameAction extends ActionSupport{
	private String name;
	private CustomerService customerService;
	private InputStream inputStream;
	
	public InputStream getResult(){
		return inputStream;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(name);
		if(customerService.findByName(name+",")){
			inputStream=new ByteArrayInputStream("true".getBytes("UTF-8"));
		}else{
			inputStream=new ByteArrayInputStream("false".getBytes("UTF-8"));
		}
		return "success";
	}
}
