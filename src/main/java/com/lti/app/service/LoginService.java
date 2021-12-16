package com.lti.app.service;

import com.lti.app.pojo.Registration;

public interface LoginService 
{
	public Registration login(String email,String password);
}
