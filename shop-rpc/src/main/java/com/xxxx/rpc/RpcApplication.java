package com.xxxx.rpc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RPC启动类
 *
 * @author zhoubin
 * @since 1.0.0
 */
@SpringBootApplication
//扫描mapper接口包
@MapperScan("com.xxxx.rpc.mapper")
public class RpcApplication {
    public static void main(String[] args) {
        SpringApplication.run(RpcApplication.class,args);
    }
}