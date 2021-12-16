package com.lti.app.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.app.pojo.Product;

@Repository
public class ProductRepo extends RootRepo 
{
	public List<Product> fetchProductInfo()
	{
		return eMan.createQuery("select p from Product p").getResultList();
	}
}
