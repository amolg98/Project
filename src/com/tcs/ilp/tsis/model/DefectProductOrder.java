package com.tcs.ilp.tsis.model;



public class DefectProductOrder 
{
	private String orderId;
	private String defectProdCode;
	private String replacementProdCode;
	private String reason;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getDefectProdCode() {
		return defectProdCode;
	}
	public void setDefectProdCode(String defectProdCode) {
		this.defectProdCode = defectProdCode;
	}
	public String getReplacementProdCode() {
		return replacementProdCode;
	}
	public void setReplacementProdCode(String replacementProdCodeList) {
		this.replacementProdCode = replacementProdCodeList;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}	
}
