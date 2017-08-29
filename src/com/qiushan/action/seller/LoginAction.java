package com.qiushan.action.seller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.bean.House;
import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;
import com.qiushan.service.SellerService;

public class LoginAction extends ActionSupport{
	private String username;
	private String password;
	private String code;
	private SellerService sellerService;
	private List<House> houses= new ArrayList<>(); //初始化
	
	
	
	public List<House> getHouses() {
		return houses;
	}
	public void setHouses(List<House> houses) {
		this.houses = houses;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("进入商家登录");
		System.out.println(username);
		System.out.println(password);
		System.out.println(code);
		if(ActionContext.getContext().getSession().get("random").equals(code)){
			Seller seller = sellerService.login(username, password);
			if(seller==null){
				ActionContext.getContext().put("loginfail", "用户名或密码错误请重新登录");
				return "loginFail";
			}
			Integer user_id=seller.getId();
			SellerDetial sellerDetial = seller.getSellerDetial();
			if(sellerDetial!=null){
				ActionContext.getContext().getSession().put("userDetial", sellerDetial);
				user_id=sellerDetial.getId();
				System.out.println("用户详细id:"+sellerDetial.getId()+"user_id:"+user_id);
			}
			//				else{
//				addFieldError("completetInf", "请先完善信息");
//				return "input";
//			}
			Set<House> houses1 = sellerService.getHouses(user_id);
			System.out.println("获取房源测试");
			if(houses1!=null){
				if(houses1.size()>0){
					Iterator<House> it = houses1.iterator();
					while(it.hasNext()){
						House house = it.next();
						System.out.println("房间的主键为:"+house.getId());
						houses.add(house);
					}
					System.out.println(houses.size());
					ActionContext.getContext().getSession().put("houses", houses);
				}
			}
			if(seller!=null){
				ActionContext.getContext().getSession().put("user", seller);
				addActionMessage("loginSuccess");
				return "loginSuccess";
			}else{
				addActionError("loginFail");
				return "loginFail";
			}
		}else{
			ActionContext.getContext().put("codeError", "验证码错误，请重新输入");
			return "codeError";
		}
	}
}	
