package com.lti.app.dto;

public class Purchase {

	private int userId;
	private int productId;
	private int tenurePeriodOpted;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getTenurePeriodOpted() {
		return tenurePeriodOpted;
	}
	public void setTenurePeriodOpted(int tenurePeriodOpted) {
		this.tenurePeriodOpted = tenurePeriodOpted;
	} 
	
	
}
