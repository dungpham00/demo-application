package com.test.demoapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demoapplication.service.DemoApplicationService;


@RestController
public class DemoApplicationController {

	@Autowired
	private DemoApplicationService service;
	
	@GetMapping("/printNumber")
	public String printNumber() {
		return "The random number is: " + service.getRandomNumber();
	}
}
