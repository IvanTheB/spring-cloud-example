package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class FrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrontEndApplication.class, args);
	}

}
