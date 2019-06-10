package com.globant.ecommerce.services;

import java.util.List;

import com.globant.ecommerce.ordermodel.Order;
/**
 * 
 * @author pravin.dake
 *
 */
public interface OrderService {
	/**
	 * this method is used for insert order data 
	 * @param order
	 * @return
	 */
	public int placeOrder(Order order);
	
	/**
	 * this method is used for get the order details by its id
	 * @param orderid
	 * @return
	 */
	public Order getOrderById(int orderid);
	
	/**
	 * this method is used to update the order status.
	 * @param status
	 * @param id
	 * @return
	 */
	public int modifyOrderStatus(String status,int id);
	/**
	 * this is method is used to authenticate user wether the user is logged in or not.
	 * @param authToken
	 * @return
	 */
	public boolean authenticate(String authToken);
}
