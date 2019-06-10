package com.globant.ecommerce.facade;

import java.util.List;

import com.globant.ecommerce.ordermodel.Order;

public interface OrderFacade {
	
	public int placeOrder(Order order);
	
	public Order getOrderById(int orderid);
	
	
	public int modifyOrderStatus(String status,int id);
	
	public boolean authenticate(String authToken);
	

}
