package com.tcs.ilp.tsis.model;

import java.sql.Date;

public class Retailer 
{
	private  String RetailerId;
	private  String ProductModelId;
	private  Date Taggeddate;
	public String getRetailerId() {
		return RetailerId;
	}
	public void setRetailerId(String retailerId) {
		RetailerId = retailerId;
	}
	public String getProductModelId() {
		return ProductModelId;
	}
	public void setProductModelId(String productModelId) {
		ProductModelId = productModelId;
	}
	public Date getTaggeddate() {
		return Taggeddate;
	}
	public void setTaggeddate(Date taggedDate) {
		Taggeddate = taggedDate;
	}
}
