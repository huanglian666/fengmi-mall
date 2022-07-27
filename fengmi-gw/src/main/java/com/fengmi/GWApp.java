package com.fengmi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GWApp
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/26 11:21
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class GWApp {
    public static void main(String[] args) {
        SpringApplication.run(GWApp.class,args);
    }
}
