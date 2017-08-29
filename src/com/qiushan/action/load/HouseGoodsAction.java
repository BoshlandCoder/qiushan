package com.qiushan.action.load;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.House;
import com.qiushan.service.CustomerService;

public class HouseGoodsAction extends ActionSupport{
	private Integer house_id;
	private Integer sellerDetial_id;
	CustomerService customerService;
	public Integer getHouse_id() {
		return house_id;
	}
	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	public Integer getSellerDetial_id() {
		return sellerDetial_id;
	}
	public void setSellerDetial_id(Integer sellerDetial_id) {
		this.sellerDetial_id = sellerDetial_id;
	}
	public CustomerService getCustomerService() {
		return customerService;
	}
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("房间具体情况");
		System.out.println(house_id);
		System.out.println(sellerDetial_id);
		House house = customerService.getHouse(house_id);
		if(house!=null){
			ActionContext.getContext().getSession().put("houseDetial", house);
			return "getHouseSuccess";
		}else{
			return "null";
		}
		
	}
}
