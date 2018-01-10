package com.example.demo;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient("service2")
public interface Service2FeignClient {
	
	@RequestMapping( value = "/message")
	String message();
}
