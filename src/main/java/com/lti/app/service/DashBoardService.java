package com.lti.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.app.pojo.EMICard;
import com.lti.app.pojo.Installments;
import com.lti.app.pojo.Purchases;

@Service
public interface DashBoardService {

	public EMICard getCard(int userId);
	public List<Purchases> getPurchaseHistory(int userId);
	public List<Installments> getInstallmentHistory(int id);
	public void upgrade(long cardNo);

	
}
