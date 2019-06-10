package com.globant.ecommerce.dao;

import java.util.List;

import com.globant.ecommerce.ordermodel.Order;

public interface OrderDAO {
	
	public int createOrder(Order order);
	
	public Order fetchOrderById(int id);
	
	public int updateOrderStatus(String status,int id);
}
