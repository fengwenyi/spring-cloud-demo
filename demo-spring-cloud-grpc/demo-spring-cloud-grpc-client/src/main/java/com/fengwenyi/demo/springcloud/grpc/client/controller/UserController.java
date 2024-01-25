package com.fengwenyi.demo.springcloud.grpc.client.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.demo.springcloud.grpc.client.vo.UserVo;
import com.fengwenyi.demo.springcloud.grpc.model.Result;
import com.fengwenyi.demo.springcloud.grpc.model.UserRequestVo;
import com.fengwenyi.demo.springcloud.grpc.model.UserResponseVo;
import com.fengwenyi.demo.springcloud.grpc.model.UserServiceGrpc;
import com.google.protobuf.InvalidProtocolBufferException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-25
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GrpcClient("demo-spring-cloud-grpc-server")
    private UserServiceGrpc.UserServiceBlockingStub userServiceBlockingStub;

    @GetMapping("/{id}")
    public ResultTemplate<UserVo> info(@PathVariable Long id) {
        Result result = userServiceBlockingStub.queryUser(UserRequestVo.newBuilder().setId(id).build());
        if (Objects.isNull(result)) {
            return ResultTemplate.fail();
        }

        UserResponseVo userResponseVo;
        try {
            userResponseVo = result.getData().unpack(UserResponseVo.class);
        } catch (InvalidProtocolBufferException e) {
            return ResultTemplate.fail(e.getMessage());
        }

        UserVo userVo = new UserVo();
        userVo.setId(userResponseVo.getId() + "");
        userVo.setName(userResponseVo.getName());
        userVo.setSex(userResponseVo.getSex());

        ResultTemplate<UserVo> resultTemplate = new ResultTemplate<>();
        resultTemplate.setBody(userVo);
        resultTemplate.setSuccess(result.getSuccess());
        resultTemplate.setMsg(result.getMessage());

        return resultTemplate;

    }

}
