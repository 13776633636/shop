package com.xxxx.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 订单启动类
 *
 * @author zhoubin
 * @since 1.0.0
 */
@SpringBootApplication
// 扫描 mapper 接口
@MapperScan("com.xxxx.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}