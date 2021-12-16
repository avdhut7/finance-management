package com.lti.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.app.pojo.Product;
import com.lti.app.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService
{

	@Autowired
	ProductRepo pr;
	
	@Override
	public List<Product> fetchProductdetails() {
		// TODO Auto-generated method stub
		return pr.fetchProductInfo();
	}

}
