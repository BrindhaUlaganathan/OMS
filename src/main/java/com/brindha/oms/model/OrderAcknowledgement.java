package com.brindha.oms.model;

import java.time.LocalDate;
import java.util.Date;

import com.brindha.oms.model.Customer;

public class OrderAcknowledgement {
	
	private String custName;
	private int orderID;
	private LocalDate orderDate;
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

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
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

	
		
	public OrderAcknowledgement(String custName, int orderID, LocalDate orderDate, String productName, int quantityOrdered) {
		super();
		this.custName = custName;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.productName = productName;
		this.quantityOrdered = quantityOrdered;
	}
	
	public OrderAcknowledgement(String custName, int orderID, LocalDate orderDate, String productName, int quantityOrdered,
			int orderLineId) {
		super();
		this.custName = custName;
		this.orderID = orderID;
		this.orderDate = orderDate;
		this.productName = productName;
		this.quantityOrdered = quantityOrdered;
		this.orderLineId = orderLineId;
	}

	@Override
	public String toString() {
		return "OrderAcknowledgement{" +
				"custName='" + custName + '\'' +
				", orderID=" + orderID +
				", orderDate=" + orderDate +
				", productName='" + productName + '\'' +
				", quantityOrdered=" + quantityOrdered +
				", orderLineId=" + orderLineId +
				'}';
	}
}
