package com.qiushan.dao.impl;

import java.util.List;

import com.qiushan.bean.House;
import com.qiushan.common.dao.impl.BaseDaoImpl;
import com.qiushan.dao.HouseDao;

public class HouseDaoImpl extends BaseDaoImpl<House> implements HouseDao{

	@Override
	public List<House> getAllHouse() {
		// TODO Auto-generated method stub
		find("from House");
		return find("from House");
	}

}
