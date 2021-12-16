package com.lti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.dto.Review;
import com.lti.app.pojo.ProductReview;
import com.lti.app.service.ProductReviewService;

@RestController
@CrossOrigin
public class ProductReviewController 
{
	@Autowired
	ProductReviewService prs;
	
	@GetMapping("/product-review-by-user")
	public List<ProductReview> fetchbyUser(int userId)
	{
		return prs.fetchbyUser(userId);
	}
	
	@DeleteMapping("/delete-review")
	public void deleteUserReview(int userId) 
	{
		prs.deleteUserReview(userId);
	}
	
	@GetMapping("/product-review-by-productId")
	public List<ProductReview> fetchbyProduct(int productId)
	{
		return prs.fetchbyProduct(productId);
	}

	@PostMapping("/add-review")
	public void addReviewFromUser(@RequestBody Review review) 
	{
		prs.addNewReview(review);
	}
}
