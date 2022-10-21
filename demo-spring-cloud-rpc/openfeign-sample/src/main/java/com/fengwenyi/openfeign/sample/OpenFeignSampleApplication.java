package com.fengwenyi.openfeign.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-21
 */
@EnableFeignClients
@SpringBootApplication
public class OpenFeignSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignSampleApplication.class, args);
    }

}
