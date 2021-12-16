package com.lti.app.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.pojo.EMICard;
import com.lti.app.pojo.Installments;
import com.lti.app.pojo.Product;
import com.lti.app.pojo.Purchases;
import com.lti.app.pojo.Registration;
import com.lti.app.repository.DashBoardRepo;
import com.lti.app.repository.RootRepo;
@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private RootRepo rootRepo;
	
	
	@Autowired
	private DashBoardRepo dashBoardRepository;
	
	@Override
	public boolean transactionEntry(int userId, int productId, int tenurePeriodOpted) {
		//this line registration keyword finally is added
		final Registration registration = rootRepo.fetch(Registration.class,userId);
		EMICard emiCard=  dashBoardRepository.fetchCardByUserId(userId);
		Product product = rootRepo.fetch(Product.class,productId);
		double remainingAmount= product.getProductPrice();
		
		if(emiCard.getBalance() > remainingAmount) {
			
			emiCard.setBalance(emiCard.getBalance() - remainingAmount);
			rootRepo.store(emiCard);
			
			product.setQuantity(product.getQuantity()-1);
			rootRepo.store(product);
			
			Purchases purchases = new Purchases();
			purchases.setDateOfPurchase(LocalDate.now());
			purchases.setTenurePeriodOpted(tenurePeriodOpted);
			purchases.setInstallmentsRemaining(tenurePeriodOpted);
			purchases.setRemainingAmount(remainingAmount);
			purchases.setEmiCard(emiCard);
			purchases.setRegistration(registration);
			purchases.setProduct(product);
			
			
			List<Installments> installments = new ArrayList<Installments>();
			
			
			
			for(int i= 0;i<tenurePeriodOpted;i++) {
				Installments installment = new Installments();
				installment.setAmountPaid(0);
				installment.setDueDate(LocalDate.now().plusMonths(i+1));
				installment.setPaymentDate(null);
				installment.setStatus("unpaid");
				installment.setPurchases(purchases);
				installments.add(installment);			
			}
			purchases.setInstallments(installments);
			rootRepo.store(purchases);
			
			return true;
			
		}else
			return false;
	}

	@Override
	public void installmentPaymentEntry(int installmentId) {
		Installments installment = rootRepo.fetch(Installments.class,installmentId);
		int purchaseId=installment.getPurchases().getId();
		Purchases purchase = rootRepo.fetch(Purchases.class,purchaseId);
		double amountPaid =	(purchase.getRemainingAmount()/purchase.getInstallmentsRemaining());
		
		EMICard emiCard = rootRepo.fetch(EMICard.class, purchase.getEmiCard().getCardNo());
		emiCard.setBalance(emiCard.getBalance() + amountPaid);
		rootRepo.store(emiCard);
		
		
		purchase.setRemainingAmount(purchase.getRemainingAmount() - amountPaid);
	    purchase.setInstallmentsRemaining(purchase.getInstallmentsRemaining()-1);
	   
	    
	   List<Installments> installments =purchase.getInstallments();
	   for (Installments installments2 : installments) {
		   if(installments2.getInstallmentId()==installmentId) {
			   
			   installments2.setAmountPaid(amountPaid);
		       installments2.setPaymentDate(LocalDate.now());
		       installments2.setStatus("paid");
		   }
		
	   }    
	   purchase.setInstallments(installments);
	   rootRepo.store(purchase);
	}
}
