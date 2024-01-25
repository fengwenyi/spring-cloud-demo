package com.fengwenyi.demo.springcloud.grpc.client.config;

import com.fengwenyi.demo.springcloud.grpc.model.UserServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-25
 */
//@Configuration
public class GrpcServiceConfig {

    @Bean
    public ManagedChannel getChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }
    @Bean
    public UserServiceGrpc.UserServiceBlockingStub userServiceStub(ManagedChannel channel) {
        return UserServiceGrpc.newBlockingStub(channel);
    }

}
