package com.lti.app.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailSenderAutoConfiguration;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.app.pojo.EMICard;
import com.lti.app.pojo.Product;
import com.lti.app.pojo.Registration;
import com.lti.app.repository.UserDetailsRepo;

@Service
public class UserDetailsSeviceImpl implements UserDetailsService
{
	
	@Autowired
	UserDetailsRepo udr;
	
	
	@Autowired
	private MailSender mailSender;
	
	
	@Override
	public List<Registration> showAll() {
		// TODO Auto-generated method stub
		return udr.getAllUsers();
	}

	@Override
	public void delete(int userId) {
		// TODO Auto-generated method stub
		udr.deleteUser(userId);
	}

	@Override
	public void updateStatus(int userId) {
		// TODO Auto-generated method stub
		udr.updateStatus(userId);
	}

	@Override
	public long addCard(int userId, String cardType) {
		// TODO Auto-generated method stub
		Registration registration = udr.fetch(Registration.class, userId);
		
		EMICard emicard = new EMICard();
		emicard.setCardType(cardType);
		emicard.setBalance(cardType.equalsIgnoreCase("gold")?100000:150000);
		emicard.setValidityOfCard(LocalDate.now().plusYears(5));
		emicard.setRegistration(registration);
		
		EMICard updatedEmiCard = (EMICard) udr.store(emicard);
		
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setFrom("springboot56@gmail.com");
		msg.setTo(registration.getEmail());
		msg.setSubject("User Activated !");
		msg.setText("Request for the card has been received. Card is generated with number " +updatedEmiCard.getCardNo());
		
		mailSender.send(msg);
		
		
		return updatedEmiCard.getCardNo();
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		udr.deleteProduct(productId);
	}

	@Override
	public int updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product updatedprod= (Product) udr.store(product);
		return updatedprod.getProductId();
	}

	@Override
	public int saveProduct(Product product) {
		// TODO Auto-generated method stub
		
		Product p = new Product();
		p.setProductName(product.getProductName());
		p.setProductDetails(product.getProductDetails());
		//System.out.println(product.getProductPrice());
		p.setProductPrice(product.getProductPrice());
		p.setProductImage(product.getProductImage());
		p.setVendor(product.getVendor());
		p.setQuantity(product.getQuantity());
		p.setMaxTenure(product.getMaxTenure());
		p.setEligibility(product.getEligibility());
		
		Product updatedProduct = (Product) udr.store(p);
		return updatedProduct.getProductId();
		
		
	}
	
}
