package com.qiushan.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.qiushan.bean.Customer;
import com.qiushan.bean.House;
import com.qiushan.bean.Seller;
import com.qiushan.common.dao.impl.BaseDaoImpl;
import com.qiushan.dao.CustomerDao;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao{

	@Override
	public Customer login(String username, String password) {
		List<Customer> lists =find("from Customer c where c.username=?0 and c.password=?1", username,password);
		if(lists.size()>0){
			return lists.get(0);
		}else{
			return null;
		}	}

	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		System.out.println("进入测试");
		List<Customer> lists=find("from Customer c where c.username=?0", name);
		if(lists.size()>=1){
			System.out.println("找着了");
			return true;
		}else{
			System.out.println("没找着了");
			return false;
		}
	}
}
 