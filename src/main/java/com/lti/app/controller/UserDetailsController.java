package com.lti.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.pojo.Product;
import com.lti.app.pojo.Registration;
import com.lti.app.service.UserDetailsService;
import com.lti.*;

@RestController
@CrossOrigin
public class UserDetailsController 
{
	@Autowired
	UserDetailsService uds;
	
	@GetMapping("/user-details")
	public List<Registration> showAll()
	{
		return  uds.showAll();		
	}
	
	@DeleteMapping("/user-delete")
	public void delete(int userId) 
	{		
		uds.delete(userId);		
	}
	
	@DeleteMapping("/product-delete")
	public void deleteProduct(int productId) 
	{		
		uds.deleteProduct(productId);		
	}
	
	@PostMapping("/product-update")
	public int updateProduct(@RequestBody Product product) 
	{		
		return uds.updateProduct(product);		
	}
	
	@PostMapping("/save-product")
	public int saveProduct(@RequestBody Product product) 
	{		
		return uds.saveProduct(product);		
	}
	
	@RequestMapping("/user-status-update")
	public void update(int userId) 
	{		
		uds.updateStatus(userId);		
	}
	
	@GetMapping("/addCard")
	public long addCard(int userId, String cardType) 
	{
		
		return uds.addCard(userId,cardType);
		
	}
}
