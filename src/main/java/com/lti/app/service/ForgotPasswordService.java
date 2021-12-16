package com.lti.app.service;

import com.lti.app.pojo.Registration;

public interface ForgotPasswordService 
{
	//@org.springframework.beans.factory.annotation.Autowired(required=true)
	public Registration getPasswordThroughEmail(String username);
}
