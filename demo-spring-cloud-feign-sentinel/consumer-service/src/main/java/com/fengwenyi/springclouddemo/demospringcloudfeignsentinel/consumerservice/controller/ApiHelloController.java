package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.IHelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/api/hello")
public class ApiHelloController {

    private IHelloClient helloClient;

    @GetMapping("/hi/{name}")
    public ResponseTemplate<String> sayHi(@PathVariable("name") String name) {
        return helloClient.sayHi(name);
    }

    @Autowired
    public void setHelloClient(IHelloClient helloClient) {
        this.helloClient = helloClient;
    }
}
