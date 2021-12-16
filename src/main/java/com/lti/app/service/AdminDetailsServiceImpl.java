package com.lti.app.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.exception.LoginServiceException;
import com.lti.app.pojo.Admin;
import com.lti.app.repository.AdminRepo;

@Service
public class AdminDetailsServiceImpl implements AdminDetailsService
{
	
	@Autowired
	AdminRepo ar;
	
	
	@Override
	public Admin login(String username, String password) 
	{
		try {
			if (!ar.checkIfPersonIsAdmin(username)) 
			{
				throw new LoginServiceException("User is not an admin!");
			}
			else 
			{
				int id = ar.findByUsernamePassword(username, password);
				Admin admin = ar.fetch(Admin.class, id);
				
				return admin;
			}
		} 
		catch (NoResultException e) 
		{
			throw new LoginServiceException("Incorrect username/password");
			// TODO: handle exception
		}
		
	}
	
}
