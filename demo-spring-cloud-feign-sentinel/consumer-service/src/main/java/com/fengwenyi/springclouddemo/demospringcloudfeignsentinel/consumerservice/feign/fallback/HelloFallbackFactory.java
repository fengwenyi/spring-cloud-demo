package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.fallback;

import com.fengwenyi.api.result.IReturnCode;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.IHelloClient;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-09
 */
@Component
public class HelloFallbackFactory implements FallbackFactory<IHelloClient> {
    @Override
    public IHelloClient create(Throwable cause) {
        return new IHelloClient() {
            @Override
            public ResponseTemplate<String> sayHi(String name) {
                return ResponseTemplate.fail(IReturnCode.Default.SERVICE_CALL_EXCEPTION);
            }
        };
    }
}
