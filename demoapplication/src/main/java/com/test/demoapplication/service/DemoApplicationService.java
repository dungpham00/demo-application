package com.test.demoapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class DemoApplicationService {

	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name="userService", fallbackMethod= "zeroNumber")
	public int getRandomNumber() {
		return this.restTemplate.getForEntity("http://numberservice/randomNumber", Integer.class).getBody();
	}
	
	public int zeroNumber() {
		return 0;
	}
}
