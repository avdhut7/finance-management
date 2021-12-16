package com.lti.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.dto.Review;
import com.lti.app.pojo.ProductReview;
import com.lti.app.repository.ProductReviewRepo;

@Service
public class ProductReviewServiceImpl implements ProductReviewService
{
	@Autowired
	ProductReviewRepo prr;
	

	@Override
	public List<ProductReview> fetchbyUser(int userId) {
		// TODO Auto-generated method stub
		return prr.fetchReviewbyUser(userId);
	}

	@Override
	public List<ProductReview> fetchbyProduct(int productId) {
		// TODO Auto-generated method stub
		return prr.fetchReviewbyProduct(productId);
	}

	@Override
	public void deleteUserReview(int userId) {
		// TODO Auto-generated method stub
		prr.deleteReview(userId);
	}

	@Override
	public void addNewReview(Review review) {
		// TODO Auto-generated method stub
		prr.addReview(review);
	}
	
}
