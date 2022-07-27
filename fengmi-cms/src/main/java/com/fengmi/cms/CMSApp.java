package com.fengmi.cms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: CMSApp
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/25 11:59
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.fengmi.cms.mapper")
public class CMSApp {
    public static void main(String[] args) {
        SpringApplication.run(CMSApp.class,args);
    }
}
