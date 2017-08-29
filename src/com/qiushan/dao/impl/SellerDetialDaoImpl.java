package com.qiushan.dao.impl;

import java.io.Serializable;

import com.qiushan.bean.SellerDetial;
import com.qiushan.common.dao.impl.BaseDaoImpl;
import com.qiushan.dao.SellerDetialDao;

public class SellerDetialDaoImpl extends BaseDaoImpl<SellerDetial> implements SellerDetialDao{

	@Override
	public SellerDetial getSellerDatial(Serializable user_id) {
		// TODO Auto-generated method stub
		return get(SellerDetial.class, user_id);
	}

}
