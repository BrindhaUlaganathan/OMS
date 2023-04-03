package com.brindha.oms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orderline")
public class OrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="order_item_number")
	private int orderItemNumber;
	@Column(name="UPC")
	private int uPC;
	@Column(name="number_of_items")
	private int numberOfItems;
	@Column(name="order_id")
	private int orderId;
	
	@ManyToOne
	@JoinColumn(name="order_id",insertable=false,nullable=false,updatable=false)
    private PurchaseOrder purchaseorder;
	

    @OneToOne
    @JoinColumn(name="UPC",insertable=false,nullable=false,updatable=false)
    Products products;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	public OrderLine(int numberOfItems) {
		super();
		this.numberOfItems = numberOfItems;
	
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
				+ ", orderId=" + orderId + "]";
	}
	


}


