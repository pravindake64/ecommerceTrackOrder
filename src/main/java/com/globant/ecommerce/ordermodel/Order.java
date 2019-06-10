package com.globant.ecommerce.ordermodel;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
/**
 * 
 * @author pravin.dake
 * 
 */
@Entity
public class Order {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int orderid;
	private String orderdate;
	private String shippeddate;
	private String expdeliverydate;
	private String ordersatatus;
	private String address;
	private String totalamount;
	

	public Order() {
		// TODO Auto-generated constructor stub
	}

	
	public Order(int id, int orderid, String orderdate, String shippeddate, String expdeliverydate,
			String ordersatatus, String address, String totalamount) {
		super();
		this.id = id;
		this.orderid = orderid;
		this.orderdate = orderdate;
		this.shippeddate = shippeddate;
		this.expdeliverydate = expdeliverydate;
		this.ordersatatus = ordersatatus;
		this.address = address;
		this.totalamount = totalamount;
	}

	
	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getTotalamount() {
		return totalamount;
	}


	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getOrderid() {
		return orderid;
	}


	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}


	public String getOrderdate() {
		return orderdate;
	}


	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}


	public String getShippeddate() {
		return shippeddate;
	}


	public void setShippeddate(String shippeddate) {
		this.shippeddate = shippeddate;
	}


	public String getExpdeliverydate() {
		return expdeliverydate;
	}


	public void setExpdeliverydate(String expdeliverydate) {
		this.expdeliverydate = expdeliverydate;
	}

	public String getOrdersatatus() {
		return ordersatatus;
	}


	public void setOrdersatatus(String ordersatatus) {
		this.ordersatatus = ordersatatus;
	}
	
	
	
	
	
}
