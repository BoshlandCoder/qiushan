package com.qiushan.dao;

import java.io.Serializable;

import com.qiushan.action.customer.LoginAction;
import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;
import com.qiushan.common.dao.BaseDao;

public interface SellerDao extends BaseDao<Seller>{
	Seller login(String username,String password);

	boolean findByName(String name);
}
