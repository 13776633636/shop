package com.xxxx.manager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 启动类
 */
@SpringBootApplication
@MapperScan("com.xxxx.manager.mapper")
@ServletComponentScan("com.xxxx.manager.interception")
public class ManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerApplication.class,args);
    }
}