package com.lti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lti.*;
import com.lti.app.pojo.Product;
import com.lti.app.service.ProductService;


@RestController
@CrossOrigin
public class ProductController 
{
	@Autowired
	ProductService ps;
	
	@GetMapping("/productlist-info")
	public List<Product> fetchProductDetails()
	{	
		return ps.fetchProductdetails();
	}
}
