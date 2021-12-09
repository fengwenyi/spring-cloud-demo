package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign;

import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.fallback.HelloFallbackFactory;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerapi.IHelloApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@FeignClient(value = "provider-service", fallbackFactory = HelloFallbackFactory.class)
public interface IHelloClient extends IHelloApi {
}
