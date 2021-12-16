package com.lti.app.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PURCHASES")
public class Purchases {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_customer_purchase_seq")
	@SequenceGenerator(sequenceName = "purchase_seq",allocationSize = 1,name = "my_customer_purchase_seq")
    @Column(name="Id")
	private int id;
	
	
	@Column(name="Tenure_Period_Opted")
	private int tenurePeriodOpted;
	
	@Column(name="Date_Of_Purchase")
	private LocalDate dateOfPurchase;
	
	
	@Column(name="Remaining_Amount")
	private double remainingAmount;
	
	@Column(name="Installments_Remaining")
	private int installmentsRemaining;
	
	
	
	@ManyToOne
	@JoinColumn(name = "User_Id")
	private Registration registration;
	
	@ManyToOne
	@JoinColumn(name = "Product_Id")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "Card_No")
	private EMICard emiCard;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "purchases", cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
	private List<Installments> installments;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getTenurePeriodOpted() {
		return tenurePeriodOpted;
	}
	public void setTenurePeriodOpted(int tenurePeriodOpted) {
		this.tenurePeriodOpted = tenurePeriodOpted;
	}
	public LocalDate getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(LocalDate dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public EMICard getEmiCard() {
		return emiCard;
	}
	public void setEmiCard(EMICard emiCard) {
		this.emiCard = emiCard;
	}
	public double getRemainingAmount() {
		return remainingAmount;
	}
	public void setRemainingAmount(double remainingAmount) {
		this.remainingAmount = remainingAmount;
	}
	public int getInstallmentsRemaining() {
		return installmentsRemaining;
	}
	public void setInstallmentsRemaining(int installmentsRemaining) {
		this.installmentsRemaining = installmentsRemaining;
	}
	
	public List<Installments> getInstallments() {
		return installments;
	}
	public void setInstallments(List<Installments> installments) {
		this.installments = installments;
	}
	
	
}
