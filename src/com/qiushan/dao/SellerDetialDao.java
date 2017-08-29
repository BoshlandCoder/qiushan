package com.qiushan.dao;

import java.io.Serializable;

import com.qiushan.bean.SellerDetial;
import com.qiushan.common.dao.BaseDao;

public interface SellerDetialDao extends BaseDao<SellerDetial>{

	SellerDetial getSellerDatial(Serializable user_id);

}
