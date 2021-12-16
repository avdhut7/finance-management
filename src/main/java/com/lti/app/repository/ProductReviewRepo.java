package com.lti.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.app.dto.Review;
import com.lti.app.pojo.Product;
import com.lti.app.pojo.ProductReview;
import com.lti.app.pojo.Registration;

@Repository
public class ProductReviewRepo extends RootRepo
{
	@PersistenceContext
	EntityManager eMan;
	
	@Autowired
	RootRepo rr;
	
	
	@Transactional
	public void deleteReview(int reviewId) 
	{
		eMan.createQuery("delete from ProductReview pr where pr.reviewId = :reviewId").setParameter("reviewId", reviewId).executeUpdate();
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductReview> fetchReviewbyUser(int userId)
	{
		return eMan.createQuery("select p from ProductReview p where p.registration.userId =: rt").setParameter("rt", userId).getResultList();		
	}
	
	@SuppressWarnings("unchecked")
	public List<ProductReview> fetchReviewbyProduct(int productId)
	{
		return eMan.createQuery("select p from ProductReview p where p.product.productId = :productId").setParameter("productId", productId).getResultList();	
	}
	
	public void addReview (Review review)
	{
		ProductReview productReview = new ProductReview();
		productReview.setRating(review.getProductReview().getRating());
		productReview.setReview(review.getProductReview().getReview());
		
		Registration registration = rr.fetch(Registration.class, review.getUserId());
		productReview.setRegistration(registration);
		
		Product product = rr.fetch(Product.class, review.getProductId());
		productReview.setProduct(product);
		
		rr.store(productReview);
		
	}
	
}
