package com.fengwenyi.demo.springcloud.nacos.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosSampleApplication.class, args);
    }

}
