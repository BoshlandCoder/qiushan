package com.qiushan.dao;

import java.util.List;

import com.qiushan.bean.House;
import com.qiushan.common.dao.BaseDao;

public interface HouseDao extends BaseDao<House>{

	List<House> getAllHouse();

}
