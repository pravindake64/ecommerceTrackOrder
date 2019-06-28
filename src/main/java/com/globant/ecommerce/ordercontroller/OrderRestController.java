package com.globant.ecommerce.ordercontroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.globant.ecommerce.dao.OrderDAOImpl;
import com.globant.ecommerce.facade.OrderFacaadeImpl;
import com.globant.ecommerce.ordermodel.Order;
import com.globant.ecommerce.ordermodel.OrderResponce;
import com.globant.ecommerce.ordermodel.Response;
/**
 * 
 * @author pravin.dake
 *
 */
@RestController
public class OrderRestController {
	@Autowired
	private OrderFacaadeImpl orderfacade;
	
	/**
	 * 
	 * @param data
	 * @param authToken
	 * @return
	 * @throws JSONException
	 */
	@PostMapping("/order/placeorder")
	public ResponseEntity<Map<String, String>> doOrder(@RequestBody String data,
			@RequestHeader(value = "authToken", defaultValue = "") String authToken) throws JSONException {
		//Response res = new Response();
		Map<String, String> resultdata = new HashMap<String, String>();
		HttpHeaders header = new HttpHeaders();
		if (orderfacade.authenticate(authToken)) {			//Checking wether the user is logged in or not
			Order order = new Order();
			JSONObject jorder = null;
			jorder = new JSONObject(data);
			
			order.setOrderid(jorder.getInt("orderid"));
			order.setOrderdate(jorder.getString("orderdate"));
			order.setShippeddate(jorder.getString("shippeddate"));
			order.setExpdeliverydate(jorder.getString("expdeliverydate"));
			order.setAddress(jorder.getString("address"));
			order.setTotalamount(jorder.getString("totalamount"));

			int result = orderfacade.placeOrder(order);
			if (result != 1) {
				//res.setMessage("Order failed");
				//res.setStatus(400);
				resultdata.put("orderstatus", "terminated");
				resultdata.put("orderid", jorder.getInt("orderid") + "");
				//res.setData(resultdata);
				header.add("message", "Order not placed");
				return new ResponseEntity<Map<String,String>>(resultdata,header,HttpStatus.BAD_REQUEST);
			} else {
				//res.setMessage("Order added");
				//res.setStatus(200);
				resultdata.put("orderstatus", "Done");
				resultdata.put("orderid", jorder.getInt("orderid") + "");
				//res.setData(resultdata);
				header.add("message", "Order placed");
				return new ResponseEntity<Map<String,String>>(resultdata,header,HttpStatus.OK);

			}
		}
		//res.setMessage("User Not Logged In");
		//res.setStatus(401);
		return new ResponseEntity<Map<String,String>>(resultdata,header,HttpStatus.UNAUTHORIZED);
	}
	/**
	 * 
	 * @param orderid
	 * @param authToken
	 * @return
	 */
	@GetMapping("/order/placeorder/{orderid}")
	public ResponseEntity<Order> getOrderById(@PathVariable("orderid") int orderid,
			@RequestHeader(value = "authToken", defaultValue = "") String authToken) {
		//OrderResponce orderresponce = new OrderResponce();
		HttpHeaders header = new HttpHeaders();
		Order order = new Order();
		if (orderfacade.authenticate(authToken)) {		//Checking wether the user is logged in or not
			order = orderfacade.getOrderById(orderid);
			if (order.equals(null)) {
				//orderresponce.setMessage("Data Not found");
				//orderresponce.setStatus("400");
				//orderresponce.setData(order);
				header.add("message", "Something went wrong");
				return new ResponseEntity<Order>(order,header,HttpStatus.NO_CONTENT);
			} else {
				//orderresponce.setMessage("Data Found");
				//orderresponce.setStatus("400");
				//orderresponce.setData(order);
				return new ResponseEntity<Order>(order,header,HttpStatus.OK);
			}
		}
		//orderresponce.setMessage("User Not Logged In");
		//orderresponce.setStatus("401");
		header.add("message", "User Not Logged In");
		return new ResponseEntity<Order>(order,header,HttpStatus.UNAUTHORIZED);
	}
	/**
	 * This Method is used to update the status of Order as follows
	 * Odered(15)
	 * Shipped(19)
	 * Delivered(4)
	 * @param data
	 * @param authToken
	 * @return
	 * @throws JSONException
	 */
	@PostMapping("/order/shiporder/updatestatus")
	public ResponseEntity<Map<String, String>> updateOrderStatus(@RequestBody String data,
			@RequestHeader(value = "authToken", defaultValue = "") String authToken) throws JSONException {
		Response resp = new Response();
		HttpHeaders header= new HttpHeaders();
		Order order = new Order();
		Map<String, String> result = new HashMap<String, String>();
		if (orderfacade.authenticate(authToken)) {		//Checking wether the user is logged in or not
			JSONObject jdata = null;
			jdata = new JSONObject(data);
			
			order.setOrderid(jdata.getInt("orderid"));
			order.setOrdersatatus(jdata.getString("orderstatus"));

			int status = orderfacade.modifyOrderStatus(jdata.getString("orderstatus"), jdata.getInt("orderid"));
			if (status != 1) {
				//resp.setMessage("Order status failed");
				//resp.setStatus(400);
				result.put("orderid", jdata.getInt("orderid") + "");
				//resp.setData(result);
				header.add("message", "Order status failed");
				return new ResponseEntity<Map<String,String>>(result,header,HttpStatus.NO_CONTENT);
			} else {
				//resp.setMessage("Order status Updated");
				//resp.setStatus(200);
				result.put("orderid", jdata.getInt("orderid") + "");
				//resp.setData(result);
				header.add("message", "Order status updated");
				return new ResponseEntity<Map<String,String>>(result,header,HttpStatus.OK);
			}
		}
		//resp.setMessage("User Not Logged In");
		//resp.setStatus(401);
		header.add("message", "User Not Logged In");
		return new ResponseEntity<>(result,header,HttpStatus.UNAUTHORIZED);
	}

}
