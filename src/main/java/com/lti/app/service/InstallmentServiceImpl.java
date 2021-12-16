package com.lti.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.pojo.Installments;
import com.lti.app.repository.InstallmentsViewRepo;

@Service
public class InstallmentServiceImpl implements InstallmentsService{
	
	@Autowired
	InstallmentsViewRepo installmentsRepository;
	@Override
	public List<Installments> fetchAllInstallments(){
		return installmentsRepository.fetchAllInstallments();
	}
	
}
