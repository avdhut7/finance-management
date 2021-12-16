package com.lti.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.pojo.Product;
import com.lti.app.service.ProductInfoService;


@RestController
@CrossOrigin
public class ProductInfoController 
{
	@Autowired
	ProductInfoService pis;
	
	@GetMapping("/product-info")
	public Product fetchProductDetails(int productId)
	{	
		return pis.fetchProductdetailsByProductId(productId);
	}
}
