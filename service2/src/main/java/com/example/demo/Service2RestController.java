package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RefreshScope
@RestController
public class Service2RestController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${message:Hello service2}")
	private String message;

    @RequestMapping("/message")
	public String message() {
		return message;
	}
	
	@HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping("/hystrixTest")
	public String hystrixTest(@RequestParam(required=false) String error) {
		if( "true".equals(error) ){
			throw new RuntimeException("Go Hystrix!");
		}
		return "No errors. Set error=true to trigger fallback";
	}
	
	public String fallback(String error) {
		return "Fallback invoked for error="+error;
	}
	

	@RequestMapping("/restTemplate")
	public String getOtherMessage() {
		String service1message = restTemplate.getForObject("http://service1/message", String.class);
		return service1message;
	}
}