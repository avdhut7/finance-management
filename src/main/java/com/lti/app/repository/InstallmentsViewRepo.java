package com.lti.app.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.lti.app.pojo.Installments;

@Repository
public class InstallmentsViewRepo extends RootRepo{

	@PersistenceContext
	EntityManager eM;
	@SuppressWarnings("unchecked")
	public List<Installments> fetchAllInstallments(){
		return eM.createQuery("select it from Installments it").getResultList();
	}
	
}
