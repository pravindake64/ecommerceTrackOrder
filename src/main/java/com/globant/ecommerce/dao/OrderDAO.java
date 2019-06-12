package com.globant.ecommerce.dao;

import java.util.List;

import com.globant.ecommerce.ordermodel.Order;
/**
 * 
 * @author pravin.dake
 *
 */
public interface OrderDAO {
	/**
	 * this method is used to insert the data of order to track the order
	 * @param order
	 * @return
	 */
	public int createOrder(Order order);
	/**
	 * this method is used to fetch the order of details by its orderid
	 * @param id
	 * @return
	 */
	public Order fetchOrderById(int id);
	/**
	 * this method is used to update the order status wether it is ordered,shipped,delivered.  
	 */
	public int updateOrderStatus(String status,int id);
}
