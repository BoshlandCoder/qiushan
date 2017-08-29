package com.qiushan.action.seller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;
import com.qiushan.service.CustomerService;
import com.qiushan.service.SellerService;

public class CompleteInfAction extends  ActionSupport{
	private SellerService sellerService;
	private int user_id;
	private SellerDetial sellerDetial;
	private int flag;
	
	
	
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public SellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	public SellerDetial getSellerDetial() {
		return sellerDetial;
	}
	public void setSellerDetial(SellerDetial sellerDetial) {
		this.sellerDetial = sellerDetial;
	}
	@Override
	public String execute() throws Exception {
		System.out.println(flag);
		System.out.println(sellerDetial.getAddress());
		if(sellerDetial.getAddress()!=null
				&&sellerDetial.getEmail()!=null
				&&sellerDetial.getIdcard()!=null
				&&sellerDetial.getName()!=null
				&&sellerDetial.getPhone()!=null
				&&sellerDetial.getAge()!=null){
			sellerDetial.setLevel(1);
			SellerDetial sellerDetial1 = sellerService.completeInf(user_id, sellerDetial,flag);
			if(sellerDetial1!=null){
				ActionContext.getContext().getSession().put("userDetial", sellerDetial1);
				addActionMessage("信息完善成功");
				return "completeInfSuccess";
			}else{
				addActionMessage("completeInfFail");
				return "completeInfFail";
			}
		}else{
			return null;
		}
			
	}
}
