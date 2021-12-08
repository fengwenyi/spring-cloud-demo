package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.providerapi;

import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2021-12-08
 */
@RequestMapping("/hello")
public interface IHelloApi {

    @GetMapping("/hi/{name}")
    ResponseTemplate<String> sayHi(@PathVariable("name") String name);

}
