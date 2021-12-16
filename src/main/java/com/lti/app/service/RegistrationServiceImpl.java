package com.lti.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lti.app.pojo.Registration;
import com.lti.app.repository.RootRepo;

@Component
public class RegistrationServiceImpl implements RegistrationService
{
	
	@Autowired
	RootRepo rr;
	

	@Override
	public int register(Registration registration) 
	{
		// TODO Auto-generated method stub
		
		Registration updatedregister = (Registration) rr.store(registration);
		return updatedregister.getUserId();
	}
	
}
