package com.fengmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: SearchApp
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/29 11:30
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.fengmi")
public class SearchApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class,args);
    }
}
