package com.fengwenyi.springboot.dubbo.consumer.service.impl;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springboot.dubbo.consumer.service.IDemoService;
import com.fengwenyi.springcloud.dubbo.sdk.service.IUserDubboService;
import com.fengwenyi.springcloud.dubbo.sdk.vo.request.UserRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@Service
@Slf4j
public class DemoServiceImpl implements IDemoService {

    @DubboReference
    private IUserDubboService userDubboService;

    @Override
    public ResultTemplate<Void> userAdd(UserRequestVo requestVo) {
        return userDubboService.add(requestVo);
    }
}
