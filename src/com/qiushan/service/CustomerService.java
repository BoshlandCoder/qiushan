package com.qiushan.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.qiushan.bean.Customer;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.bean.House;
import com.qiushan.vo.UserCart;

public interface CustomerService {
	//切记面向对象操作
	
	/*
	 * 
	 * 登录
	 * 
	 * */
	Customer login(String username,String password);
	/*
	 * 把物品添加到购物车
	 * 
	 * */
	boolean addCart(Serializable user_id,Serializable house_id);
	/*
	 * 
	 * 浏览购物车
	 * 
	 * */
	List<UserCart> browseCart(Serializable customer_id); 
	/*
	 * 
	 * 将物品移出购物车
	 * 
	 * */
	boolean removeCart(Serializable user_id,Serializable cart_id);
	/*
	 * 
	 * 购买商品
	 * 
	 * */
	boolean buyHouse_goods(Serializable user_id,Serializable house_id);
	/*
	 * 
	 * 注册(用验证码)
	 * 
	 * */
	boolean regist(String username,String password);
	/*
	 * 
	 * 完善个人信息
	 * 
	 * */
	CustomerDetial completeInf(Serializable customer_id,CustomerDetial customerDetial,Integer flag);
	
	boolean findByName(String name);
	/*
	 * 
	 * 取得所有房源
	 * 
	 * */
	List<House> getAllHouse();
	/*
	 * 获得具体房源
	 * 
	 * */
	House getHouse(Integer house_id);
	
}
