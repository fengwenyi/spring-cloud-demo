package com.fengwenyi.rpc;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
@Configuration
@ConditionalOnClass(MyRpc.class)
public class MyRpcAutoConfig {

    @Bean
    public MyClient myClient() {
        return new MyClientImpl();
    }

}
