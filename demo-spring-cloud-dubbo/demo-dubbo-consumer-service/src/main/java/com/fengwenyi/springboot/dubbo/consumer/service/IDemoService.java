package com.fengwenyi.springboot.dubbo.consumer.service;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springcloud.dubbo.sdk.vo.request.UserRequestVo;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
public interface IDemoService {
    ResultTemplate<Void> userAdd(UserRequestVo requestVo);
}
