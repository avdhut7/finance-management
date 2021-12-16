package com.lti.app.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class LoginRepo extends RootRepo
{
	public boolean isCustomerPresent(String username)
	{
		
		//Query q=entityManager.createQuery("select c from Customer c where c.email:em");
		//q.setParameter(, value)
		
		return (Long) eMan.createQuery("select count(r.userId) from Registration r where r.username = :username").setParameter("username", username).getSingleResult() ==1 ? true :false;

		//count returns long and getSingleResult returns here object type casted it to long
		
	}
	
	public int findByUsrnameAndPassword(String username,String password)
	{
		return (int) eMan.createQuery("select r.userId from Registration r where r.username = :username and r.password = :password").setParameter("username", username).setParameter("password", password).getSingleResult();
		
	}
	
	public String userActivated(int id)
	{
		return (String) eMan.createQuery("select r.userStatus from Registration r where r.userId = :id").setParameter("id", id).getSingleResult();
	}
}
