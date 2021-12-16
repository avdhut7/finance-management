package com.lti.app.pojo;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "EMI_CARD")
public class EMICard {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "my_customer_emicard_seq")
	@SequenceGenerator(sequenceName = "emicard_seq",allocationSize = 15463,name = "my_customer_emicard_seq")
	
	@Column(name = "CARD_NO")
	private long cardNo;

	@Column(name = "Validity")
	private LocalDate validityOfCard;

	@Column(name = "Type")
	private String cardType;

	@Column(name = "Balance")
	private double balance;

	
	
	@OneToOne
	@JoinColumn(name = "User_Id")
	private Registration registration;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "emiCard")
	private List<Purchases> purchases; 
	
	

	public long getCardNo() {
		return cardNo;
	}

	public void setCardNo(long cardNo) {
		this.cardNo = cardNo;
	}

	public List<Purchases> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchases> purchases) {
		this.purchases = purchases;
	}

	public LocalDate getValidityOfCard() {
		return validityOfCard;
	}

	public void setValidityOfCard(LocalDate validityOfCard) {
		this.validityOfCard = validityOfCard;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Registration getRegistration() {
		return registration;
	}

	public void setRegistration(Registration registration) {
		this.registration = registration;
	}

}
