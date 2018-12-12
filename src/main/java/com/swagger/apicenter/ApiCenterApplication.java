package com.swagger.apicenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author cuizhiquan
 * @Description
 * @date 2018/12/12 12:23
 * @Copyright (c) 2017, DaChen All Rights Reserved.
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ApiCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiCenterApplication.class, args);
	}
}
