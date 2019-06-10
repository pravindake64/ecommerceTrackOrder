package com.globant.ecommerce.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.globant.ecommerce.ordermodel.Order;

@Repository("/orderDAO")
public class OrderDAOImpl implements OrderDAO {
	@Autowired
	private JdbcTemplate jdbctemplate;

	
	@Override
	public int createOrder(Order order) {
		final String sql = "insert into ecommerce.order(orderid,orderdate,shippeddate,expdeliverydate,address,totalamount) values(?,?,?,?,?,?)";
		Object param[] = {order.getOrderid(),order.getOrderdate(),order.getShippeddate(),order.getExpdeliverydate(),order.getAddress(),order.getTotalamount()};
		int res = jdbctemplate.update(sql, param);
		return res;
	}

	@Override
	public Order fetchOrderById(int orderid) {
		// TODO Auto-generated method stub
		final String sql = "select * from ecommerce.order where orderid=?";
		Object param[] = { orderid };
		Order order = jdbctemplate.queryForObject(sql, param, new BeanPropertyRowMapper<Order>(Order.class));

		return order;
	}

	@Override
	public int updateOrderStatus(String status,int id) {
		// TODO Auto-generated method stub
		final String sql = "update ecommerce.order set orderstatus=? where orderid=?";
		Object param[] = {status,id};
		int orderstatus=jdbctemplate.update(sql, param);
		return orderstatus;
	}

}
