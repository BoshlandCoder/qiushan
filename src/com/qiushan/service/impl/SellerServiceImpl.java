package com.qiushan.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.qiushan.bean.House;
import com.qiushan.bean.House_goods;
import com.qiushan.bean.Seller;
import com.qiushan.bean.SellerDetial;
import com.qiushan.dao.CartDao;
import com.qiushan.dao.CustomerDao;
import com.qiushan.dao.CustomerDetialDao;
import com.qiushan.dao.HouseDao;
import com.qiushan.dao.House_goodsDao;
import com.qiushan.dao.ManagerDao;
import com.qiushan.dao.OrderDao;
import com.qiushan.dao.SellerDao;
import com.qiushan.dao.SellerDetialDao;
import com.qiushan.service.SellerService;
import com.qiushan.tools.Tools;

public class SellerServiceImpl implements SellerService{
	private CartDao cartDao;
	private CustomerDao customerDao;
	private ManagerDao managerDao;
	private OrderDao orderDao;
	private SellerDao sellerDao;
	private HouseDao houseDao;
	private CustomerDetialDao customerDetialDao;
	private SellerDetialDao sellerDetialDao;
	private House_goodsDao house_goodsDao;
	
	
	
	public House_goodsDao getHouse_goodsDao() {
		return house_goodsDao;
	}
	public void setHouse_goodsDao(House_goodsDao house_goodsDao) {
		this.house_goodsDao = house_goodsDao;
	}
	public SellerDetialDao getSellerDetialDao() {
		return sellerDetialDao;
	}
	public void setSellerDetialDao(SellerDetialDao sellerDetialDao) {
		this.sellerDetialDao = sellerDetialDao;
	}
	public CustomerDetialDao getCustomerDetialDao() {
		return customerDetialDao;
	}
	public void setCustomerDetialDao(CustomerDetialDao customerDetialDao) {
		this.customerDetialDao = customerDetialDao;
	}
	public HouseDao getHouseDao() {
		return houseDao;
	}
	public void setHouseDao(HouseDao houseDao) {
		this.houseDao = houseDao;
	}
	public CartDao getCartDao() {
		return cartDao;
	}
	public void setCartDao(CartDao cartDao) {
		this.cartDao = cartDao;
	}
	public CustomerDao getCustomerDao() {
		return customerDao;
	}
	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	public ManagerDao getManagerDao() {
		return managerDao;
	}
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}
	public OrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}
	public SellerDao getSellerDao() {
		return sellerDao;
	}
	public void setSellerDao(SellerDao sellerDao) {
		this.sellerDao = sellerDao;
	}
	@Override
	public boolean regist(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Seller seller = new Seller();
			seller.setUsername(username);
			seller.setPassword(password);
			sellerDao.save(seller);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	@Override
	public Seller login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			return sellerDao.login(username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public SellerDetial completeInf(Serializable seller_id,SellerDetial sellerDetial,int flag) {
		// TODO Auto-generated method stub
		if(flag==0){
			try {
				Seller seller = sellerDao.get(Seller.class, seller_id);
				sellerDetialDao.save(sellerDetial);
				seller.setSellerDetial(sellerDetial);
				System.out.println("sellerDetial的ID"+sellerDetial.getId());
				return sellerDetial;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}else{
			try {
				SellerDetial sellerDetial2 = sellerDetialDao.get(SellerDetial.class, seller_id);
				sellerDetial2=sellerDetial;
				sellerDetialDao.update(sellerDetial2);
				return sellerDetial2;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}
	}
	@Override
	public House addHouse(Serializable seller_id, House house) {
		// TODO Auto-generated method stub
		try {
			SellerDetial sellerDetial =sellerDetialDao.get(SellerDetial.class, seller_id);
			houseDao.save(house);
			System.out.println("添加房源");
			sellerDetial.getHouses().add(house);
			String[] date = Tools.getDate();
			for(int i=0;i<date.length;i++){
				House_goods house_goods = new House_goods();
				house_goods.setDay(date[i]);
				house_goodsDao.save(house_goods);
				house.getHouse_goods().add(house_goods);
				houseDao.update(house);
			}
			return house;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public boolean modifyHouse(Serializable seller_id, Serializable house_id,House house) {
		// TODO Auto-generated method stub
		try {
			House house1 = houseDao.get(House.class, house_id);
			house1=house;
			houseDao.save(house1);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}	
	}
	@Override
	public boolean removeHouse(Serializable seller_id, Serializable house_id) {
		// TODO Auto-generated method stub
		try {
			SellerDetial sellerDetial = sellerDetialDao.get(SellerDetial.class, seller_id);
			House house = houseDao.get(House.class, house_id);
			sellerDetial.getHouses().remove(house);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		if(sellerDao.findByName(name)){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public SellerDetial getSellerDetial(Serializable user_id) {
		// TODO Auto-generated method stub
		SellerDetial sellerDetial = sellerDetialDao.getSellerDatial(user_id);
		if(sellerDetial!=null){
			return sellerDetial;
		}
		return null;
	}
	@Override
	public Set<House> getHouses(Serializable user_id) {
		// TODO Auto-generated method stub
		SellerDetial sellerDetial = sellerDetialDao.getSellerDatial(user_id);
		if(sellerDetial!=null){
			return sellerDetial.getHouses();
		}else{
			return null;
		}
	}
	@Override
	public boolean saveImage(Serializable house_id, String[] imageName) {
		House house = houseDao.get(House.class, house_id);
		if(imageName.length>0){
			int len=imageName.length;
			switch (len) {
				case 1:
					house.setTp_1(imageName[0]);
					break;
				case 2:
					house.setTp_1(imageName[0]);
					house.setTp_2(imageName[1]);
					break;
				case 3:
					house.setTp_1(imageName[0]);
					house.setTp_2(imageName[1]);
					house.setTp_3(imageName[2]);
					break;
				case 4:
					house.setTp_1(imageName[0]);
					house.setTp_2(imageName[1]);
					house.setTp_3(imageName[2]);
					house.setTp_4(imageName[3]);
					break;
				case 5:
					house.setTp_1(imageName[0]);
					house.setTp_2(imageName[1]);
					house.setTp_3(imageName[2]);
					house.setTp_4(imageName[3]);
					house.setTp_5(imageName[4]);
					break;
				case 6:
					house.setTp_1(imageName[0]);
					house.setTp_2(imageName[1]);
					house.setTp_3(imageName[2]);
					house.setTp_4(imageName[3]);
					house.setTp_5(imageName[4]);
					house.setTp_6(imageName[5]);
				default:
					break;
				}
		}
		try {
			houseDao.update(house);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
