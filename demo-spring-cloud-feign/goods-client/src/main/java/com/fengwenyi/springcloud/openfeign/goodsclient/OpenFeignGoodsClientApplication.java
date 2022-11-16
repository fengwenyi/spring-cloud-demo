package com.fengwenyi.springcloud.openfeign.goodsclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-16
 */
@EnableFeignClients
@SpringBootApplication
public class OpenFeignGoodsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenFeignGoodsClientApplication.class, args);
    }

}
