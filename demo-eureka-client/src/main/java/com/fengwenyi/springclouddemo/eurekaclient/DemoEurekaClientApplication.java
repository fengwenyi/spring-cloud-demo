package com.fengwenyi.springclouddemo.eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-11-03
 */
@SpringBootApplication
@EnableEurekaClient
public class DemoEurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaClientApplication.class, args);
    }

}
