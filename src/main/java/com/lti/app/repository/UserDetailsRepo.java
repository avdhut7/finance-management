package com.lti.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.app.pojo.Registration;

@Repository
public class UserDetailsRepo extends RootRepo
{
	@PersistenceContext
	EntityManager eMan;
	
	@SuppressWarnings("uncheked")
	public List<Registration> getAllUsers()
	{
		return eMan.createQuery("select r from Registration r").getResultList();
	}
	
	@Transactional
	public void deleteUser(int userId)
	{
		eMan.createQuery("delete from Registration r where r.userId = :userId").setParameter("userId", userId).executeUpdate();
	}
	
	@Transactional
	public void updateStatus(int userId)
	{
		eMan.createQuery("update Registration r set r.userStatus = :status  where r.userId = :userId").setParameter("userId", userId).setParameter("status", "activated").executeUpdate();
	}
	
	@Transactional
	public void deleteProduct(int productId)
	{
		eMan.createQuery("delete from Product p where p.productId = :productId").setParameter("productId", productId).executeUpdate();
	}
}
