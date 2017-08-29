package com.qiushan.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.qiushan.bean.House;
import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;

public interface SellerService {
	/*
	 * 
	 * 商家注册
	 * 
	 * */
	boolean regist(String username,String password);
	/*
	 * 
	 * 商家登录
	 * 
	 * */
	Seller login(String username, String password);
	/*
	 * 
	 * 完善商家信息
	 * 
	 * */
	SellerDetial completeInf(Serializable seller_id,SellerDetial sellerDetial,int flag);
	/*
	 * 
	 * 增添商品
	 * 
	 * */
	House addHouse(Serializable seller_id,House house);
	/*
	 * 
	 * 
	 *修改商品信息 
	 * 
	 * 
	 */
	boolean modifyHouse(Serializable seller_id,Serializable house_id,House house);
	/*
	 * 
	 * 删除商品信息
	 * 
	 * 
	 * */
	boolean removeHouse(Serializable seller_id,Serializable house_id);
	boolean findByName(String name);
	SellerDetial getSellerDetial(Serializable user_id);
	Set<House> getHouses(Serializable user_id);
	boolean saveImage(Serializable house_id,String[] imageName);
}
