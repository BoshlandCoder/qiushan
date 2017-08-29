package com.qiushan.action.load;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.House;
import com.qiushan.service.CustomerService;

public class LoadHoseAction extends ActionSupport{
	private CustomerService customerService;
	private List<House> houses;
	
	
	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}


	public CustomerService getCustomerService() {
		return customerService;
	}


	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}


	@Override
	public String execute() throws Exception {
		System.out.println("获取房源");
		houses=customerService.getAllHouse();
		ActionContext.getContext().getSession().put("allhouse", houses);
		return "index";
	}
}
