package com.UserProfile.UserProfile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
@EnableFeignClients
@RestController
public class UserProfileApplication {
	@Autowired
	DiscoveryClient client;

	@RequestMapping("/")
	public String hello() {
		//ServiceInstance localInstance = client.getLocalServiceInstance();
		//return "Hello World: "+ localInstance.getServiceId()+":"+localInstance.getHost()+":"+localInstance.getPort();
		return "i'm userprofile service and i host this function";
	}

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApplication.class, args);
	}
}
