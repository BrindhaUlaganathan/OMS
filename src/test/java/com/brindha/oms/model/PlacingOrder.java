package com.brindha.oms.model;

public class PlacingOrder {
	
	private int customerNo;
	private int uPC;
	private String prodDescription;
	private int noOfItems;
	
	public int getcustomerNo() {
		return customerNo;
	}
	public void setCust_no(int customerNo) {
		this.customerNo = customerNo;
	}
	public int getuPC() {
		return uPC;
	}
	public void setuPC(int uPC) {
		this.uPC = uPC;
	}
	public String getProdDescription() {
		return prodDescription;
	}
	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}
	public int getNoOfItems() {
		return noOfItems;
	}
	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}
	
	public PlacingOrder(int customerNo,int uPC, String prodDescription, int noOfItems) {
		this.uPC=uPC;
		this.customerNo = customerNo;
		this.prodDescription = prodDescription;
		this.noOfItems = noOfItems;
	}

	@Override
	public String toString() {
		return "PlacingOrder{" +
				"customerNo=" + customerNo +
				", uPC=" + uPC +
				", prodDescription='" + prodDescription + '\'' +
				", noOfItems=" + noOfItems +
				'}';
	}
}
