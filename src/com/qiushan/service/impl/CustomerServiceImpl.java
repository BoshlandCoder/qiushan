package com.qiushan.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.qiushan.bean.Cart;
import com.qiushan.bean.Customer;
import com.qiushan.bean.CustomerDetial;
import com.qiushan.bean.House;
import com.qiushan.dao.CartDao;
import com.qiushan.dao.CustomerDao;
import com.qiushan.dao.CustomerDetialDao;
import com.qiushan.dao.HouseDao;
import com.qiushan.dao.House_goodsDao;
import com.qiushan.dao.ManagerDao;
import com.qiushan.dao.OrderDao;
import com.qiushan.dao.SellerDao;
import com.qiushan.dao.SellerDetialDao;
import com.qiushan.service.CustomerService;
import com.qiushan.vo.UserCart;

public class CustomerServiceImpl implements CustomerService{
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
	public Customer login(String username, String password) {
		// TODO Auto-generated method stub
		Customer customer=null;
		try {
			 customer=customerDao.login(username, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(customer!=null){
			return customer;
		}else{
			return null;
		}
		
	}
	@Override
	public boolean addCart(Serializable user_id, Serializable house_id) {
		// TODO Auto-generated method stub
		/*
		 * 1.加载商品  2.构成购物车 .给用户添加购物车
		 * 
		 * */
		try {
			House house = houseDao.get(House.class, house_id);
			CustomerDetial customerDetial = customerDetialDao.get(CustomerDetial.class, user_id);
			Cart cart = new Cart();
			cart.setId(100);
			cart.setHouse(house);
			cartDao.save(cart);
			customerDetial.getCarts().add(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("此房源已在您的购物车中");
			return false;
		}
	}
	@Override
	public List<UserCart> browseCart(Serializable customer_id) {
		// TODO Auto-generated method stub
		CustomerDetial customerDetial = customerDetialDao.get(CustomerDetial.class, customer_id);
		Set<Cart> carts=customerDetial.getCarts();
		List<UserCart> houses = new ArrayList<>();
		Iterator<Cart> it = carts.iterator();
		while(it.hasNext()){
			UserCart userCart = new UserCart();
			Cart cart = it.next();
			userCart.setHouse(cart.getHouse());
			userCart.setUser_id(cart.getId()+"");
			houses.add(userCart);
			
			//ids.add(it.next().getId());
		}
		if(houses!=null){
			//存储用户购物项id
			//ActionContext.getContext().getSession().put("cartids", ids);
			return houses;
		}
		return null;
	}
	@Override
	public boolean removeCart(Serializable user_id, Serializable cart_id) {
		// TODO Auto-generated method stub
		/*
		 * 删除购物车一项
		 * 
		 * */
		try {
			Customer customer = customerDao.get(Customer.class, user_id);
			Cart cart = cartDao.get(Cart.class, cart_id);
			customer.getCustomerDetial().getCarts().remove(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	@Override
	public boolean buyHouse_goods(Serializable user_id, Serializable house_id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean regist(String username, String password) {
		// TODO Auto-generated method stub
		try {
			Customer customer = new Customer();
			customer.setPassword(password);
			customer.setUsername(username);
			customerDao.save(customer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public CustomerDetial completeInf(Serializable customer_id, CustomerDetial customerDetial,Integer flag) {
		// TODO Auto-generated method stub
		if(flag==0){
			try {
				Customer customer = customerDao.get(Customer.class, customer_id);
				customerDetialDao.save(customerDetial);
				customer.setCustomerDetial(customerDetial);
				return customerDetial;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return null;
			}
		}else{
			try{
				CustomerDetial customerDetial2 =customerDetialDao.get(CustomerDetial.class, customer_id);
				customerDetial2=customerDetial;
				customerDetialDao.update(customerDetial2);
				return customerDetial2;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	}
	@Override
	public boolean findByName(String name) {
		// TODO Auto-generated method stub
		if(customerDao.findByName(name)){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public List<House> getAllHouse() {
		// TODO Auto-generated method stub
		List<House> houses = houseDao.getAllHouse();
		return houses;
	}
	@Override
	public House getHouse(Integer house_id) {
		try {
			House house=houseDao.get(House.class, house_id);
			return house;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
}
