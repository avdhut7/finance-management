package com.lti.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.app.repository.AutoChangeStatusRepo;

@Component("due")
public class AutoStatusUpdateService {
//
//	@Autowired
//	AutoChangeStatusRepository autoChangeStatusRepository;
//	
//	@Autowired
//	private MailSender mailSender;
// 
//    public void changeStatus() {
//
//    	List<Installments> installments = autoChangeStatusRepository.fetchAllInstallment();
//    	for (Installments installment : installments) {
//    		
//			LocalDate dueDate = installment.getDueDate();
//			int purchaseId =installment.getPurchases().getId();
//			Purchases purchases=autoChangeStatusRepository.fetch(Purchases.class,purchaseId);
//			int userId=purchases.getRegistration().getUserId();
//			Registration registration=autoChangeStatusRepository.fetch(Registration.class,userId);
//			
//			
//			if(installment.getStatus().equalsIgnoreCase("unpaid")) {
//				if(dueDate.compareTo(LocalDate.now()) <= 0) {
//					installment.setStatus("due");
//					
//					SimpleMailMessage message = new SimpleMailMessage();
//					message.setFrom("guptasubhajit272@gmail.com");
//					message.setTo(registration.getEmail());
//					message.setSubject("Installment payment due.");
//					message.setText("Installment payment last date today.");
//					
//					mailSender.send(message);
//				}
//			}
//			else if(installment.getStatus().equalsIgnoreCase("due")) {
//				
//				Purchases purchase = autoChangeStatusRepository.fetch(Purchases.class, installment.getPurchases().getId());
//				purchase.setRemainingAmount(purchase.getRemainingAmount()*101/100);	
//				autoChangeStatusRepository.store(purchase);
//				
//				
//				SimpleMailMessage message = new SimpleMailMessage();
//				message.setFrom("guptasubhajit272@gmail.com");
//				message.setTo(registration.getEmail());
//				message.setSubject("Installment payment due.");
//				message.setText("email installment due ,still not paid for "+ LocalDate.now().compareTo(dueDate) + " days. Each day your remaining amount to be paid is fined by 1%.");
//				
//				mailSender.send(message);
//
//			}
//			
//			autoChangeStatusRepository.store(installment);
//			
//		}
//    	
//    }
}
