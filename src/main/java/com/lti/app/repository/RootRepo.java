package com.lti.app.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public class RootRepo 
{
	@PersistenceContext
	EntityManager eMan;
	
	@Transactional
	public Object store(Object obj)
	{
		Object updatedObj = eMan.merge(obj);
		return updatedObj;
		
	}
	
	public <E> E  fetch(Class<E> cl, Object pk) 
	{	
		E  e = eMan.find(cl, pk);
		return e;
	}
}
