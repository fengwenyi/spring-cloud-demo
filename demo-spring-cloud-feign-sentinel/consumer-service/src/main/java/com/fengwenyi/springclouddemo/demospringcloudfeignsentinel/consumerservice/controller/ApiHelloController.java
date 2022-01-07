package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.controller;

import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.IHello2Client;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.IHello3Client;
import com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice.feign.IHelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@RestController
@RequestMapping("/api/hello")
public class ApiHelloController {

    private IHelloClient helloClient;
    private IHello2Client hello2Client;
    private IHello3Client hello3Client;

    @Autowired
    public void setHelloClient(IHelloClient helloClient) {
        this.helloClient = helloClient;
    }

    @Autowired
    public void setHello2Client(IHello2Client hello2Client) {
        this.hello2Client = hello2Client;
    }

    @Autowired
    public void setHello3Client(IHello3Client hello3Client) {
        this.hello3Client = hello3Client;
    }

    @GetMapping("/hi/{name}")
    public ResponseTemplate<String> sayHi(@PathVariable("name") String name) {
        return helloClient.sayHi(name);
    }

    @GetMapping("/get")
    public ResponseTemplate<String> get() {
//        return helloClient.get();
        return hello2Client.get();
    }

    @GetMapping("/post")
    public ResponseTemplate<String> post() {

        Map<String, Object> user = Map.of("name", "张三", "age", 18);

        return hello3Client.post(user);
    }

}
