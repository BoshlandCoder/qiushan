package com.qiushan.action.seller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetHouseAction extends ActionSupport{
	private Integer house_id;

	public Integer getHouse_id() {
		return house_id;
	}

	public void setHouse_id(Integer house_id) {
		this.house_id = house_id;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(house_id);
		ActionContext.getContext().put("house_id", house_id);
		return "success";
	}
}
