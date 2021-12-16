package com.lti.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.dto.RegisterStatus;
import com.lti.app.dto.Status.StatusType;
import com.lti.app.exception.LoginServiceException;
import com.lti.app.pojo.Registration;
import com.lti.app.service.RegistrationService;
import com.lti.*;

@RestController
@CrossOrigin
public class RegistrationController 
{
	@Autowired
	RegistrationService rs;
	
	@PostMapping("/registration")
	public @ResponseBody RegisterStatus register(@RequestBody Registration registration)
	{
		try 
		{
			int id = rs.register(registration);
			
			
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.SUCESS);
			status.setMessage("Registration Successful");
			status.setRegisteredCustomerId(id);
			return status;

		} 
		
		catch (LoginServiceException e) 
		{
			RegisterStatus status = new RegisterStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		} 
		
	}
	
	
}
