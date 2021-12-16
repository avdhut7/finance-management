package com.lti.app.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRODUCT_REVIEW")
public class ProductReview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_customer_productreview_seq")
	@SequenceGenerator(sequenceName = "productreview_seq",allocationSize = 1,name = "my_customer_productreview_seq")
	@Column(name="Review_Id")
	private int reviewId;
	
	@Column(name="Review")
	private String review;
	
	@Column(name="Rating")
	private int rating;
	
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private Registration  registration;
	
	@ManyToOne
	@JoinColumn(name = "Product_Id")
	private Product product;
	

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}




}
