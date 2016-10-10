package com.tcs.ilp.tsis.model;

public class ProductStockTable 
{
	String prodCode;
	String prodModelId;
	String prodModelName;
	String prodModelStatus;
	int orderId;
	
	public String getProdCode() {
		return prodCode;
	}
	public void setProdCode(String prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdModelId() {
		return prodModelId;
	}
	public void setProdModelId(String prodModelId) {
		this.prodModelId = prodModelId;
	}
	public String getProdModelName() {
		return prodModelName;
	}
	public void setProdModelName(String prodModelName) {
		this.prodModelName = prodModelName;
	}
	public String getProdModelStatus() {
		return prodModelStatus;
	}
	public void setProdModelStatus(String prodModelStatus) {
		this.prodModelStatus = prodModelStatus;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}
