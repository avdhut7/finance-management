package com.lti.app.repository;

import org.springframework.stereotype.Repository;

@Repository
public class AdminRepo extends RootRepo 
{
	public boolean checkIfPersonIsAdmin(String username)
	{
		return (Long) eMan.createQuery("select count(a.adminId) from Admin a where a.username = :username").setParameter("username", username).getSingleResult() ==1 ? true :false;
	}
	
	public int findByUsernamePassword(String username, String password)
	{
		return (int) eMan.createQuery("select a.adminId from Admin a where a.username = :username and a.password = :password").setParameter("username", username).setParameter("password", password).getSingleResult();
	}
	
}
