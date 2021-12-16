package com.lti.app.repository;

import org.springframework.stereotype.Repository;

import com.lti.app.pojo.Registration;

@Repository
public class ForgotPasswordRepo extends RootRepo
{
	public Registration getPasswordByDatabaseThroughEmail(String username) 
	{		
	     return (Registration)
			eMan.createQuery("select r from Registration r where r.username =:username").setParameter("username",username).getSingleResult();
	}
}
