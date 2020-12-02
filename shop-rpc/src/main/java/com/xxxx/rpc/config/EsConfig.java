package com.xxxx.rpc.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.Objects;

/**
 * elasticsearch配置类
 */

@Configuration
public class EsConfig {
    //es服务器地址
    @Value("${elasticsearch.address}")
    private String [] address;

    //es服务器连接方式
    private static final String SCHEME = "http";

    /**
     * 根据服务器地址构建HttpHost对象
     * @param s
     * @return
     */
    @Bean
    public HttpHost builderHttpHost(String s){
        String[] address = s.split(":");
        if (2!=address.length){
            return null;
        }
        String host = address[0];
        Integer port = Integer.valueOf(address[1]);
        return new HttpHost(host,port,SCHEME);
    }

    /**
     * 创建RestClientBuilder对象
     * @return
     */
    @Bean
    public RestClientBuilder restClientBuilder(){
        HttpHost[] hosts = Arrays.stream(address)
                .map(this::builderHttpHost)
                .filter(Objects::nonNull)
                .toArray(HttpHost[]::new);
            return RestClient.builder(hosts);
    }

    /**
     * 创建RestHighLevelClient对象
     * @param restClientBuilder
     * @return
     */
    @Bean
    public RestHighLevelClient restHighLevelClient(@Autowired RestClientBuilder restClientBuilder){

        return new RestHighLevelClient(restClientBuilder);

    }

}
