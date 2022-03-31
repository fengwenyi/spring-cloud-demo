package com.fengwenyi.springclouddemo.demospringcloudalibabasentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-03-31
 */
@RestController
public class DemoController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

}
