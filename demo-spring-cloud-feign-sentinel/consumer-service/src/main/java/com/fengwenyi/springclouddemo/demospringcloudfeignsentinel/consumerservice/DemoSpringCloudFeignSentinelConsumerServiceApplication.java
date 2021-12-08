package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class DemoSpringCloudFeignSentinelConsumerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudFeignSentinelConsumerServiceApplication.class, args);
    }

}
