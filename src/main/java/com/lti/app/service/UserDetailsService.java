package com.lti.app.service;

import java.util.List;

import com.lti.app.pojo.Product;
import com.lti.app.pojo.Registration;
import com.lti.app.*;

public interface UserDetailsService 
{
	public List<Registration> showAll();
	public void delete(int userId);
	public void updateStatus(int userId);
	public long addCard(int userId, String cardType);
	public void deleteProduct(int productId);
	public int updateProduct(Product product);
	public int saveProduct(Product product);
}
