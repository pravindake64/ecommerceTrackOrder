package com.globant.ecommerce.ordermodel;

import java.util.List;
import java.util.Map;

import org.json.JSONObject;
/**
 * 
 * @author pravin.dake
 * This method is used to send response of method in JSON format.
 * 
 */
public class Response {
	
	private String Message;
	private Map<String, String> data;
	private int status;
	
	
	public Response() {
		// TODO Auto-generated constructor stub
	}


	public Response(String message, Map<String, String> data, int status) {
		super();
		Message = message;
		this.data = data;
		this.status = status;
	}


	public Map<String, String> getData() {
		return data;
	}


	public void setData(Map<String, String> data) {
		this.data = data;
	}


	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

}
