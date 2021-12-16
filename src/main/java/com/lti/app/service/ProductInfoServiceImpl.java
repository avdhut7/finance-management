package com.lti.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.pojo.Product;
import com.lti.app.repository.ProductInfoRepo;
import com.lti.app.repository.ProductRepo;

@Service
public class ProductInfoServiceImpl implements ProductInfoService
{

	@Autowired
	ProductInfoRepo pR;
	
	@Override
	public Product fetchProductdetailsByProductId(int productId) {
		// TODO Auto-generated method stub
		return pR.fetchProductInfoByProductId(productId);
	}
	
}
