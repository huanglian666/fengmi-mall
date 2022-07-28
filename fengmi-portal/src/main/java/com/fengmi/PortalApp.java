package com.fengmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName: PortalApp
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/26 10:00
 **/
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.fengmi"})
public class PortalApp {
    public static void main(String[] args) {
        SpringApplication.run(PortalApp.class,args);
    }
}
