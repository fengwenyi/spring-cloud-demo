package com.fengwenyi.springboot.dubbo.consumer.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.dubbo.consumer.service.IDemoService;
import com.fengwenyi.springcloud.dubbo.sdk.vo.request.UserRequestVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    private final IDemoService demoService;

    public DemoController(IDemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/userAdd")
    public ResultTemplate<Void> userAdd(@RequestBody UserRequestVo requestVo) {
        return demoService.userAdd(requestVo);
    }

}
