package com.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients

public class ServiceApplication {
	@Autowired
	HelloClient client;

	@RequestMapping("/")
	public String hello() {
		return client.hello();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

	@FeignClient("user-profile")
	interface HelloClient {
		@RequestMapping(value = "/", method = GET)
		String hello();
	}
}
