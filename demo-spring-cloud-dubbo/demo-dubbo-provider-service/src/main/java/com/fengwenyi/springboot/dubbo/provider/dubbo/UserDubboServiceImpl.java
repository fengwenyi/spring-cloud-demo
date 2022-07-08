package com.fengwenyi.springboot.dubbo.provider.dubbo;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.javalib.convert.JsonUtils;
import com.fengwenyi.springcloud.dubbo.sdk.service.IUserDubboService;
import com.fengwenyi.springcloud.dubbo.sdk.vo.request.UserRequestVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-07-08
 */
@DubboService
@Slf4j
public class UserDubboServiceImpl implements IUserDubboService {
    @Override
    public ResultTemplate<Void> add(UserRequestVo requestVo) {
        log.info("dubbo consumer add requestVo: [{}]", JsonUtils.convertString(requestVo));
        return ResultTemplate.success();
    }
}
