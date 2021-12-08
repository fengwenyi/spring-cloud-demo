package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoSpringCloudFeignSentinelProviderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringCloudFeignSentinelProviderServiceApplication.class, args);
    }

}
