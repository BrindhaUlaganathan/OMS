package com.brindha.oms.service;

import java.util.Date;

import com.brindha.oms.model.Customer;

public class OrderAcknowledgement {
	
	private String custName;
	private int orderID;
	private Date orderDate;
	private String productName;
	private int quantityOrdered;
	private int orderLineId;

	public int getOrderLineId() {
		return orderLineId;
	}

	public void setOrderLineId(int orderLineId) {
		this.orderLineId = orderLineId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}
	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	
		
	public OrderAcknowledgement(String custName, int orderID, Date orderDate, String productName, int quantityOrdered) {
		super();
		this.custName = custName;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.productName = productName;
		this.quantityOrdered = quantityOrdered;
	}
	
	public OrderAcknowledgement(String custName, int orderID, Date orderDate, String productName, int quantityOrdered,
			int orderLineId) {
		super();
		this.custName = custName;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.productName = productName;
		this.quantityOrdered = quantityOrdered;
		this.orderLineId = orderLineId;
	}



}
