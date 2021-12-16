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
import com.lti.app.pojo.Registration;
import com.lti.app.service.LoginService;
import com.lti.*;


@RestController
@CrossOrigin
public class LoginController 
{
	@Autowired
	LoginService ls;
	
	@PostMapping("/login")
	public @ResponseBody LoginStatus login(@RequestBody Login login) 
	{
		try 
		{
			Registration registration = ls.login(login.getUsername(), login.getPassword());
			LoginStatus status = new LoginStatus();
			status.setStatus(StatusType.SUCESS);
			status.setMessage("Login Successful");
			status.setCustomerId(registration.getUserId());
			status.setCustomerName(registration.getName());
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
