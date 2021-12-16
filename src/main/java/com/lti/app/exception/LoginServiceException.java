package com.lti.app.exception;

public class LoginServiceException extends RuntimeException 
{

	public LoginServiceException() {
		super();
		
	}

	public LoginServiceException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public LoginServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public LoginServiceException(String arg0) {
		super(arg0);
	
	}

	public LoginServiceException(Throwable arg0) {
		super(arg0);
		
	}
	
}
