package com.fengmi.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: GoodsApp
 * @Description: //TODO
 * @Author: huanglian
 * @Date: 2022/7/27 15:31
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.fengmi.goods.mapper")
public class GoodsApp {
    public static void main(String[] args) {
        SpringApplication.run(GoodsApp.class,args);
    }
}
