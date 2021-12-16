package com.lti.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PRODUCT")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_customer_product_seq")
	@SequenceGenerator(sequenceName = "product_seq",allocationSize = 1,name = "my_customer_product_seq")
	@Column(name = "Product_Id")
	private int productId;
	
	@Column(name = "Product_name" )
	private String productName;
	
	private String vendor;
	
	@Column(name = "Price")
	private double productPrice;
	
	@Column(name = "Details")
	private String productDetails;
	
	private String eligibility;
	
	private int quantity;
	
	@Column(name = "Max_Tenure_Period")
	private int maxTenure;
	
	@Column(name = "IMAGE")
	private String productImage;
	

	@JsonIgnore
	@OneToMany(mappedBy = "product")
	private List<Purchases> purchases;

	@JsonIgnore
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ProductReview> reviews;
	

	public int getProductId() {
		return productId;
	}


	public void setProductId(int productId) {
		this.productId = productId;
	}


	public List<Purchases> getPurchases() {
		return purchases;
	}


	public void setPurchases(List<Purchases> purchases) {
		this.purchases = purchases;
	}


	public List<ProductReview> getReviews() {
		return reviews;
	}


	public void setReviews(List<ProductReview> reviews) {
		this.reviews = reviews;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public String getVendor() {
		return vendor;
	}


	public void setVendor(String vendor) {
		this.vendor = vendor;
	}


	public double getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}


	public String getProductDetails() {
		return productDetails;
	}


	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}





	


	public String getEligibility() {
		return eligibility;
	}


	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public int getMaxTenure() {
		return maxTenure;
	}


	public void setMaxTenure(int maxTenure) {
		this.maxTenure = maxTenure;
	}


	public String getProductImage() {
		return productImage;
	}


	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	
	

}
