package com.globant.ecommerce.facade;

import java.util.List;

import com.globant.ecommerce.ordermodel.Order;
/**
 * 
 * @author pravin.dake
 *
 */
public interface OrderFacade {

	/**
	 * This mathod used to insert the data of Order
	 * @param order
	 * @return
	 */
	public int placeOrder(Order order);
	
	/**
	 * This method is used to get the order details by orderid 
	 * @param orderid
	 * @return
	 */
	public Order getOrderById(int orderid);
	
	/**
	 * This method us is used to update the Order status.
	 * @param status
	 * @param id
	 * @return
	 */
	public int modifyOrderStatus(String status, int id);
	
	/**
	 * This method is used to check the login wether the user is logged in or not.
	 * @param authToken
	 * @return
	 */
	public boolean authenticate(String authToken);

}
