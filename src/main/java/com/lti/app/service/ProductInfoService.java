package com.lti.app.service;

import com.lti.app.pojo.Product;

public interface ProductInfoService 
{
	public Product fetchProductdetailsByProductId(int productId);
}
