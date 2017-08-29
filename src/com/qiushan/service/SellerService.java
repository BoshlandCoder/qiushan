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
	 * �̼�ע��
	 * 
	 * */
	boolean regist(String username,String password);
	/*
	 * 
	 * �̼ҵ�¼
	 * 
	 * */
	Seller login(String username, String password);
	/*
	 * 
	 * �����̼���Ϣ
	 * 
	 * */
	SellerDetial completeInf(Serializable seller_id,SellerDetial sellerDetial,int flag);
	/*
	 * 
	 * ������Ʒ
	 * 
	 * */
	House addHouse(Serializable seller_id,House house);
	/*
	 * 
	 * 
	 *�޸���Ʒ��Ϣ 
	 * 
	 * 
	 */
	boolean modifyHouse(Serializable seller_id,Serializable house_id,House house);
	/*
	 * 
	 * ɾ����Ʒ��Ϣ
	 * 
	 * 
	 * */
	boolean removeHouse(Serializable seller_id,Serializable house_id);
	boolean findByName(String name);
	SellerDetial getSellerDetial(Serializable user_id);
	Set<House> getHouses(Serializable user_id);
	boolean saveImage(Serializable house_id,String[] imageName);
}
