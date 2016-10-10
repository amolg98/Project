package com.tcs.ilp.tsis.model;

public class CompPackageTable 
{
	String packageId;
	String Offers;
	Double minOrderAmount;
	Double maxOrderAmount;
	
	public String getPackageId() {
		return packageId;
	}
	public void setPackageId(String packageId) {
		this.packageId = packageId;
	}
	public String getOffers() {
		return Offers;
	}
	public void setOffers(String offers) {
		Offers = offers;
	}
	public Double getMinOrderAmount() {
		return minOrderAmount;
	}
	public void setMinOrderAmount(Double minOrderAmount) {
		this.minOrderAmount = minOrderAmount;
	}
	public Double getMaxOrderAmount() {
		return maxOrderAmount;
	}
	public void setMaxOrderAmount(Double maxOrderAmount) {
		this.maxOrderAmount = maxOrderAmount;
	}
	
}
