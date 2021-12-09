package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerservice.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerapi.IHelloApi;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@RestController
public class HelloController implements IHelloApi {
    @Override
    public ResponseTemplate<String> sayHi(String name) {

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var hi = "Hi ";
        return ResponseTemplate.success(hi + name);
    }
}
