package com.boya.platform.configmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 服务配置
 * @author jingz
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigMicroServiceApplication.class, args);
	}
}
