package com.qiushan.action.seller;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.opensymphony.xwork2.ActionSupport;
import com.qiushan.service.SellerService;

public class FindNameAction extends ActionSupport{
	private String name;
	private InputStream inputStream;
	private SellerService sellerService;
	
	public InputStream getResult(){
		return inputStream;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SellerService getSellerService() {
		return sellerService;
	}
	public void setSellerService(SellerService sellerService) {
		this.sellerService = sellerService;
	}
	@Override
	public String execute() throws Exception {
		System.out.println("商家用户名验证");
		System.out.println(", "+name);
		if(sellerService.findByName(name)){
			inputStream = new ByteArrayInputStream("true".getBytes());
		}else{
			inputStream = new ByteArrayInputStream("false".getBytes());
		}
		// TODO Auto-generated method stub
		return "success";
	}
}
