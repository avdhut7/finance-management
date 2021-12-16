package com.lti.app.dto;

import com.lti.app.pojo.ProductReview;

public class Review {
	
	private int userId;
	private int productId;
	private ProductReview productReview;
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
	public ProductReview getProductReview() {
		return productReview;
	}
	public void setProductReview(ProductReview productReview) {
		this.productReview = productReview;
	}
}
