package com.fengwenyi.springboot.dubbo.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@SpringBootApplication
@EnableDubbo
@EnableDiscoveryClient
public class DemoDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoDubboConsumerApplication.class, args);
    }

}
