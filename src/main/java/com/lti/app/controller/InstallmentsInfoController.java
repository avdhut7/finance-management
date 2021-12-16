package com.lti.app.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.app.pojo.Installments;
import com.lti.app.service.InstallmentsService;

@RestController
@RequestMapping
@CrossOrigin
public class InstallmentsInfoController {

	@Autowired
	private InstallmentsService installmentService;
	@GetMapping("/installments-info")
	public List<Installments> fetchAllInstallments(){
		return installmentService.fetchAllInstallments();
	}
	
}
