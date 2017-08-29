package com.qiushan.action.seller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.House;
import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;
import com.qiushan.service.SellerService;

public class AddHouseAction extends ActionSupport{
	private SellerService sellerService;
	private House house;
	private int user_id;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public SellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	
	@Override
	public String execute() throws Exception {
		
		System.out.println("添加房源");
		
		SellerDetial sellerDetial = (SellerDetial) ActionContext.getContext().getSession().get("userDetial");
		Seller seller = (Seller) ActionContext.getContext().getSession().get("user");
		System.out.println("用户ID"+seller.getSellerDetial());
		System.out.println();
		if(sellerDetial!=null){
			user_id=sellerDetial.getId();
		}else{
			if(seller.getSellerDetial()!=null){
				user_id=seller.getSellerDetial().getId();
			}else{
				addFieldError("completetInf", "请先完善信息");
				return "input";
			}
		}
		house.setHot(0);
		house.setHouseuser_id(user_id);
		House house1=sellerService.addHouse(user_id, house);
		if(house1!=null){
			addActionMessage("addHouseSuccess");
			ActionContext.getContext().getSession().put("newHouse", house1);
			return "addHouseSuccess";
		}else{
			addActionMessage("addHouseFail");
			return "addHouseFail";
		}
	}
}
