package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RefreshScope
@RestController
public class Service1RestController {

	@Autowired
	private RestTemplate restTemplate; //@LoadBalanced restemplate
	
	@Autowired
	private Service2FeignClient service2FeignClient; //a Feign Client
	
	@Autowired
	private DiscoveryClient discoveryClient; //abstraction over Eureka

	@Value("${message:Hello service1}")
	private String message;

	@RequestMapping("/message")
	public String message() {
		return this.message;
	}

	/**
	 * Example with a @LoadBalanced RestTemplate
	 */
	@RequestMapping("/restTemplate")
	public String restTemplate() {
		String service2message = restTemplate.getForObject("http://service2/message", String.class);
		return service2message;
	}
	
	/**
	 * Example with a FeignClient
	 */
	@RequestMapping("/feignClient")
	public String feignClient() {
		String service2message = service2FeignClient.message();
		return service2message;
	}
	
	/**
	 * Test the DiscoveryClient
	 */
	@RequestMapping("/service2info")
	public String service2info() {
		List<ServiceInstance> list = discoveryClient.getInstances("service2");
	    if (list != null && list.size() > 0 ) {
	        ServiceInstance serviceInstance = list.get(0);
			return serviceInstance.getUri().toString();
	    }
	    return null;
	}
}