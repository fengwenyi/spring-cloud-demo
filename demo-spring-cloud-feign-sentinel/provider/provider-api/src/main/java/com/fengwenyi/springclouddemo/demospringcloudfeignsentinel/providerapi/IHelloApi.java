package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerapi;

import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


public interface IHelloApi {

    @GetMapping("/hello/{name}")
    ResponseTemplate<String> sayHi(@PathVariable("name") String name);

}
