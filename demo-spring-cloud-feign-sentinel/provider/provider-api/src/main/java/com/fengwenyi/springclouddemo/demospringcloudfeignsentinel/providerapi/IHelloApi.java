package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerapi;

import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;


public interface IHelloApi {

    @GetMapping("/hello/{name}")
    ResponseTemplate<String> sayHi(@PathVariable("name") String name);

    @GetMapping("/get")
    ResponseTemplate<String> get();

    @PostMapping("/post")
    ResponseTemplate<String> post(@RequestBody Map<String, Object> data);

}
