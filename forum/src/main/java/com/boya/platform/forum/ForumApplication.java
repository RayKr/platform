package com.boya.platform.forum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 论坛子项目入口，启用注册发现
 * @author Tsunglei Ching
 * @date 2017-11-27
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.boya.platform.forum.mapper")
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}
}
