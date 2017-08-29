package com.qiushan.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.qiushan.bean.Customer;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.bean.House;
import com.qiushan.vo.UserCart;

public interface CustomerService {
	//�м�����������
	
	/*
	 * 
	 * ��¼
	 * 
	 * */
	Customer login(String username,String password);
	/*
	 * ����Ʒ��ӵ����ﳵ
	 * 
	 * */
	boolean addCart(Serializable user_id,Serializable house_id);
	/*
	 * 
	 * ������ﳵ
	 * 
	 * */
	List<UserCart> browseCart(Serializable customer_id); 
	/*
	 * 
	 * ����Ʒ�Ƴ����ﳵ
	 * 
	 * */
	boolean removeCart(Serializable user_id,Serializable cart_id);
	/*
	 * 
	 * ������Ʒ
	 * 
	 * */
	boolean buyHouse_goods(Serializable user_id,Serializable house_id);
	/*
	 * 
	 * ע��(����֤��)
	 * 
	 * */
	boolean regist(String username,String password);
	/*
	 * 
	 * ���Ƹ�����Ϣ
	 * 
	 * */
	CustomerDetial completeInf(Serializable customer_id,CustomerDetial customerDetial,Integer flag);
	
	boolean findByName(String name);
	/*
	 * 
	 * ȡ�����з�Դ
	 * 
	 * */
	List<House> getAllHouse();
	/*
	 * ��þ��巿Դ
	 * 
	 * */
	House getHouse(Integer house_id);
	
}
