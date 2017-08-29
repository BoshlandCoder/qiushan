package com.qiushan.action.customer;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.bean.House;
import com.qiushan.service.CustomerService;
import com.qiushan.vo.UserCart;

public class BrowseCartAction extends ActionSupport{
	private CustomerService customerService;
	private int user_id;
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
	@Override
	public String execute() throws Exception {
		System.out.println("������ﳵ");
		System.out.println("����������ﳵ"+user_id);
		if(ActionContext.getContext().getSession().get("userDetial")==null){
			System.out.println("��û�����û���Ϣ��");
			ActionContext.getContext().put("completeInf", "�������Ƹ�����Ϣ");
			return "completeInf";
		}
		List<UserCart> houses = customerService.browseCart(user_id);
		
		if(houses!=null){
			ActionContext.getContext().getSession().put("orderhouses", houses);
			addActionMessage("browseCartSuccess");
			return "browseCartSuccess";
		}else{
			addActionMessage("browseCartFail");
			return null;
		}
	}
}
