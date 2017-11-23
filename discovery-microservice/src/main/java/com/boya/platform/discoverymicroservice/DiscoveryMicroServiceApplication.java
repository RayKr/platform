package com.boya.platform.discoverymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 发现服务
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017-11-23
 */
@SpringBootApplication
@EnableEurekaServer
public class DiscoveryMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryMicroServiceApplication.class, args);
	}
}
