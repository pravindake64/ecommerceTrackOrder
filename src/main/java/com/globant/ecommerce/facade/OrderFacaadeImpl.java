package com.globant.ecommerce.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.globant.ecommerce.ordermodel.Order;
import com.globant.ecommerce.services.OrderServiceImpl;
@Repository("orderFacade")
public class OrderFacaadeImpl implements OrderFacade {
	@Autowired
	private OrderServiceImpl orderservice;
	@Override
	public int placeOrder(Order order) {
		// TODO Auto-generated method stub
		return orderservice.placeOrder(order);
	}

	@Override
	public Order getOrderById(int orderid) {
		// TODO Auto-generated method stub
		return orderservice.getOrderById(orderid);
	}

	@Override
	public int modifyOrderStatus(String status, int id) {
		// TODO Auto-generated method stub
		return orderservice.modifyOrderStatus(status, id);
	}

	@Override
	public boolean authenticate(String authToken) {
		// TODO Auto-generated method stub
		return orderservice.authenticate(authToken);
	}

	


	

}
