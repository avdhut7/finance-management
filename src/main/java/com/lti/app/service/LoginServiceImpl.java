package com.lti.app.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.exception.LoginServiceException;
import com.lti.app.pojo.Registration;
import com.lti.app.repository.LoginRepo;

@Service
public class LoginServiceImpl implements LoginService
{

	@Autowired
	private LoginRepo lr;
	
	
	@Override
	public Registration login(String username, String password) {
		// TODO Auto-generated method stub
		
		try {
			
			if(!lr.isCustomerPresent(username))
			{
				throw new LoginServiceException("Customer Not Registered !");
			}
			else
			{
				int id = lr.findByUsrnameAndPassword(username, password);
				if(lr.userActivated(id).equalsIgnoreCase("activated")) 
				{
					Registration registration = lr.fetch(Registration.class, id);
					return registration;
				}
				else 
				{
					throw new LoginServiceException();
				}
			} 
			
		} 
		catch (NoResultException e) 
		{
			// TODO: handle exception
			
			throw new LoginServiceException("Incorrect username/password");
		}
		
	}

}
