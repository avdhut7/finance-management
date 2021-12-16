package com.lti.app.service;

import java.util.List;

import com.lti.app.dto.Review;
import com.lti.app.pojo.ProductReview;

public interface ProductReviewService 
{
	public List<ProductReview> fetchbyUser(int userId);
	
	public List<ProductReview> fetchbyProduct(int productId);
	
	public void deleteUserReview(int userId);
	
	public void addNewReview(Review review);
}
