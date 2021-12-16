package com.lti.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lti.app.pojo.Registration;
import com.lti.app.service.ForgotPasswordService;
import com.lti.app.service.UserDetailsService;

@SpringBootTest
class FinanceApplicationTests {

	@Autowired
	ForgotPasswordService fps;
	
	@Autowired
	UserDetailsService uds;
	
	
	
	@Test
	public void testforgotpass ()
	{
		Registration r1= new Registration(  );
		boolean tes = fps.getPasswordThroughEmail("nancy") != null;
		assertEquals(true, tes);
	}
	
}
