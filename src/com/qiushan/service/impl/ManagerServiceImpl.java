package com.qiushan.service.impl;

import com.qiushan.dao.CartDao;
import com.qiushan.dao.CustomerDao;
import com.qiushan.dao.CustomerDetialDao;
import com.qiushan.dao.HouseDao;
import com.qiushan.dao.House_goodsDao;
import com.qiushan.dao.ManagerDao;
import com.qiushan.dao.OrderDao;
import com.qiushan.dao.SellerDao;
import com.qiushan.dao.SellerDetialDao;

public class ManagerServiceImpl {
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
	
}
