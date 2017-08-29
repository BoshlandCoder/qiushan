package com.qiushan.dao.impl;

import java.io.Serializable;
import java.util.List;

import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;
import com.qiushan.common.dao.impl.BaseDaoImpl;
import com.qiushan.dao.SellerDao;

public class SellerDaoImpl extends BaseDaoImpl<Seller> implements SellerDao{

	@Override
	public Seller login(String username, String password) {
		// TODO Auto-generated method stub
		List<Seller> lists =find("from Seller s where s.username=?0 and s.password=?1", username,password);
		if(lists.size()>0){
			return lists.get(0);
		}else{
			return null;
		}
	}

	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		List<Seller> lists=find("from Seller s where s.username=?0", name);
		if(lists.size()>=1){
			System.out.println("�̼Ұ�����ѯ�ɹ�");
			return true;
		}else{
			System.out.println("�̼Ұ�����ѯʧ��");
			return false;
		}
	}

}
