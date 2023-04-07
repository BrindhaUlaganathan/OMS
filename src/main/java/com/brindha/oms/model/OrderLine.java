package com.brindha.oms.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orderline")
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_item_number")
	private int orderItemNumber;
	@Column(name = "UPC")
	private int uPC;
	@Column(name = "number_of_items")
	private int numberOfItems;
	@Column(name = "order_id")
	private int orderId;


	@ManyToOne//(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable = false, nullable = false, updatable = false)
	private PurchaseOrder purchaseorder;
	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "UPC", insertable = false, nullable = false, updatable = false)
	private Products products;


	public int getOrderItemNumber() {
		return orderItemNumber;
	}

	public void setOrderItemNumber(int orderItemNumber) {
		this.orderItemNumber = orderItemNumber;
	}

	public int getuPC() {
		return uPC;
	}

	public void setuPC(int uPC) {
		this.uPC = uPC;
	}

	public int getNumberOfItems() {
		return numberOfItems;
	}

	public void setNumberOfItems(int numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public OrderLine() {
		super();
	}


	public OrderLine(int orderId) {

		this.orderId = orderId;

	}

	public OrderLine(int numberOfItems, int orderId) {
		super();
		this.numberOfItems = numberOfItems;
		this.orderId = orderId;
	}

	public OrderLine(int uPC, int numberOfItems, int orderId) {
		super();
		this.uPC = uPC;
		this.numberOfItems = numberOfItems;
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderLine [orderItemNumber=" + orderItemNumber + ", uPC=" + uPC + ", numberOfItems=" + numberOfItems
				+ "]";
	}

	public OrderLine(int orderItemNumber, int uPC, int numberOfItems, int orderId) {
		this.orderItemNumber = orderItemNumber;
		this.uPC = uPC;
		this.numberOfItems = numberOfItems;
		this.orderId = orderId;

	}

//	public OrderLine(int orderItemNumber, int uPC, int numberOfItems, int orderId, PurchaseOrder purchaseorder, Products products) {
//		this.orderItemNumber = orderItemNumber;
//		this.uPC = uPC;
//		this.numberOfItems = numberOfItems;
//		this.orderId = orderId;
//		this.purchaseorder = purchaseorder;
//		this.products = products;
//	}
//}
}