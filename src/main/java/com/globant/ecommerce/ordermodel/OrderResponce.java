package com.globant.ecommerce.ordermodel;

public class OrderResponce {
	
	private String message;
	private Order data;
	private String status;
	
	public OrderResponce() {
		// TODO Auto-generated constructor stub
	}

	public OrderResponce(String message, Order data, String status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Order getData() {
		return data;
	}

	public void setData(Order data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
