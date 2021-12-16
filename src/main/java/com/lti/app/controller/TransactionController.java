package com.lti.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.dto.Purchase;
import com.lti.app.dto.Status;
import com.lti.app.dto.Status.StatusType;
import com.lti.app.service.TransactionService;

@RestController
@RequestMapping
@CrossOrigin
public class TransactionController 
{
	@Autowired
	private TransactionService tService;
	
	@PostMapping("/transaction")
	public @ResponseBody Status getBuyingStatus(@RequestBody Purchase purchase)
	{
		if(tService.transactionEntry(purchase.getUserId(),purchase.getProductId(),purchase.getTenurePeriodOpted()))
		{
			Status status = new Status();
			status.setStatus(StatusType.SUCESS);
		
			status.setMessage("Payment Successfull !");
			return status;
		}
		
		else
		{
			Status status = new Status();
			status.setStatus(StatusType.FAILED);
			status.setMessage("Payment Rejected!! Not enough credits.");
			
			return status;
		}
	}
	
	@GetMapping("/installment-payment")
	public @ResponseBody Status gettingPaymentUpdates(@RequestParam("installmentId") int installmentId)
	{
		tService.installmentPaymentEntry(installmentId);
		Status status = new Status();
		status.setStatus(StatusType.InstallmentPaid);
		status.setMessage("Your EMI for this month is paid");
		return status;
	}
}
