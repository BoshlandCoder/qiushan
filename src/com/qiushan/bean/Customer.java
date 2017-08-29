package com.qiushan.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer_inf")
public class Customer {
	@Id
	@Column(name="customer_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable=false)
	private String username;
	@Column(nullable=false)
	private String password;
	@OneToOne(targetEntity=CustomerDetial.class)
	@JoinColumn(name="customer_detial_id",referencedColumnName="customer_detial_id",unique=true)
	private CustomerDetial customerDetial;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public CustomerDetial getCustomerDetial() {
		return customerDetial;
	}
	public void setCustomerDetial(CustomerDetial customerDetial) {
		this.customerDetial = customerDetial;
	}
	
}
