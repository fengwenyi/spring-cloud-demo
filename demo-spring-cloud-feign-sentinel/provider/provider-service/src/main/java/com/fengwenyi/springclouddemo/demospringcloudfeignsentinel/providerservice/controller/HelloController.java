package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerservice.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerapi.IHelloApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@RestController
@Slf4j
public class HelloController implements IHelloApi {
    @Override
    public ResponseTemplate<String> sayHi(String name) {

        try {
            Thread.sleep(3 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var hi = "Hi ";
        return ResponseTemplate.success(hi + name);
    }

    @Override
    public ResponseTemplate<String> get() {


        log.info("request");

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseTemplate.success();
    }

    @Override
    public ResponseTemplate<String> post(Map<String, Object> data) {

        data.forEach((k, v) -> {
            System.out.printf("key=%s, value=%s\n", k, v);
        });

        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ResponseTemplate.success();
    }
}
