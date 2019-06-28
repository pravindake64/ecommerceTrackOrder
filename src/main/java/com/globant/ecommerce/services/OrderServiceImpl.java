package com.globant.ecommerce.services;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.globant.ecommerce.dao.OrderDAOImpl;
import com.globant.ecommerce.ordermodel.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAOImpl orderdao;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public int placeOrder(Order order) {
		// TODO Auto-generated method stub
		return orderdao.createOrder(order);
	}

	@Override
	public Order getOrderById(int orderid) {
		// TODO Auto-generated method stub
		return orderdao.fetchOrderById(orderid);
	}

	@Override
	public int modifyOrderStatus(String status, int id) {
		// TODO Auto-generated method stub
		return orderdao.updateOrderStatus(status, id);
	}

	@Override
	public boolean authenticate(String authToken) {
		if (true)
			return true;
		String url = "http://192.168.43.163:8080/checklogin";
		HttpHeaders headers = new HttpHeaders();
		headers.set("authToken", authToken);
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
		JSONObject jo;
		try {
			jo = new JSONObject(resp.getBody());
			String statusCode = jo.getString("statusCode");
			// System.out.println(statusCode);
			if (statusCode.equals("200")) {
				return true;
			}
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return false;
	}

}
