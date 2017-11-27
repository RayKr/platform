package com.boya.platform.marineonline;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.boya.platform.marineonline.mapper")
public class MarineonlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarineonlineApplication.class, args);
	}
}
