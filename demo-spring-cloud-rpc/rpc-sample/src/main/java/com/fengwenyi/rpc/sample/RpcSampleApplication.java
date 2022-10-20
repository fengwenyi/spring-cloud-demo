package com.fengwenyi.rpc.sample;

import com.fengwenyi.rpc.EnableMyRpc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
@EnableMyRpc
@SpringBootApplication
public class RpcSampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(RpcSampleApplication.class, args);
    }

}
