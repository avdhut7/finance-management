package com.lti.app.service;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.lti.app.exception.LoginServiceException;
import com.lti.app.pojo.Registration;
import com.lti.app.repository.ForgotPasswordRepo;

@Service
public class ForgotPasswordImpl implements ForgotPasswordService
{
	@Autowired
	ForgotPasswordRepo fpr;
	
	
	@Autowired
	MailSender mailSender;
	
	@Autowired
	private MailSenderService service;
	
	
	@Override
	public Registration getPasswordThroughEmail(String username) 
	{
		try 
		{
			Registration registration= fpr.getPasswordByDatabaseThroughEmail(username);
			String emailId=registration.getEmail();
			String password=registration.getPassword();
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("springboot56@gmail.com");
			message.setTo(emailId);
			message.setSubject("New Password Request.");
			message.setText(password);
			
			mailSender.send(message);
			return registration;
		}
		catch (NoResultException e) 
		{

			throw new LoginServiceException("User not found !");

		}
		
	}
	
}
