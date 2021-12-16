package com.lti.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.app.pojo.Installments;

@Repository
public class AutoChangeStatusRepo extends RootRepo{

	@PersistenceContext
	EntityManager entityManager;
	

	@SuppressWarnings("unchecked")
	public List<Installments> fetchAllInstallment(){
		
		return entityManager.createQuery("select i from Installments i").getResultList();
	}
	
}
