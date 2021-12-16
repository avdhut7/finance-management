package com.lti.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.dto.Login;
import com.lti.app.dto.LoginStatus;
import com.lti.app.dto.Status.StatusType;
import com.lti.app.exception.LoginServiceException;
import com.lti.app.pojo.Admin;
import com.lti.app.service.AdminDetailsService;
import com.lti.*;


@RestController
@CrossOrigin
public class AdminDetailsController 
{
	@Autowired
	AdminDetailsService ads;
	
	@PostMapping("/admin-login")
	public @ResponseBody LoginStatus login(@RequestBody Login login) 
	{
		try 
		{
			Admin admin = ads.login(login.getUsername(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCESS);
			status.setMessage("Login Success !");
			
			
			return status;

		} 
		
		catch (LoginServiceException e) 
		{
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
	}
}
