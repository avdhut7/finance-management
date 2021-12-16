package com.lti.app.service;

public interface TransactionService {
	
	public boolean transactionEntry(int userId,int productId,int tenurePeriodOpted);
	public void installmentPaymentEntry(int installmentId);

}
