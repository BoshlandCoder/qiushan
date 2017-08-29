package com.qiushan.dao;

import java.io.Serializable;

import com.qiushan.bean.Cart;
import com.qiushan.bean.Customer;
import com.qiushan.bean.House;
import com.qiushan.bean.Order;
import com.qiushan.common.dao.BaseDao;

import java.util.List;
import java.util.Set;

public interface CustomerDao extends BaseDao<Customer>{
	Customer login(String username,String password);

	boolean findByName(String name);
}
