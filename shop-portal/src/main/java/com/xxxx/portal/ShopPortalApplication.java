package com.xxxx.portal;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xxxx.portal.mapper")
@EnableDubbo
@SpringBootApplication
public class ShopPortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopPortalApplication.class, args);
    }

}
