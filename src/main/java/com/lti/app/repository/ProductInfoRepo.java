package com.lti.app.repository;

import org.springframework.stereotype.Repository;

import com.lti.app.pojo.Product;

@Repository
public class ProductInfoRepo extends RootRepo
{
	@SuppressWarnings("unchecked")
	public Product fetchProductInfoByProductId(int productId)
	{
		return (Product) eMan.createQuery("select p from Product p where p.productId =: productId").setParameter("productId", productId).getSingleResult();
		
	}
}
