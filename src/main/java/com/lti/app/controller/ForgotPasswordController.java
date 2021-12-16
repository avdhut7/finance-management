package com.lti.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.dto.Status;
import com.lti.app.dto.Status.StatusType;
import com.lti.app.exception.LoginServiceException;
import com.lti.app.pojo.Registration;
import com.lti.app.service.ForgotPasswordService;

@RestController
@CrossOrigin
public class ForgotPasswordController 
{
	@Autowired
	ForgotPasswordService fps;
     
	@GetMapping("/recover-password")
	public @ResponseBody Status gettingPaymentUpdates(@RequestParam("username") String username) 
	{
		try 
		{
		Registration registration= fps.getPasswordThroughEmail(username);
		
			Status status = new Status();
			status.setStatus(StatusType.SUCESS);
			status.setMessage(registration.getUsername()+" password recovered check your mail !");
			return status;
		}
		catch (LoginServiceException e) 
		{
			Status status = new Status();
			status.setStatus(StatusType.FAILED);
			status.setMessage(e.getMessage());
			return status;
		}
		
	}
}
