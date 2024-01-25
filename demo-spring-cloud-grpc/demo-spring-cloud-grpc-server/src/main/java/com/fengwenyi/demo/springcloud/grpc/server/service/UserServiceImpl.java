package com.fengwenyi.demo.springcloud.grpc.server.service;

import com.fengwenyi.demo.springcloud.grpc.model.Result;
import com.fengwenyi.demo.springcloud.grpc.model.UserRequestVo;
import com.fengwenyi.demo.springcloud.grpc.model.UserResponseVo;
import com.fengwenyi.demo.springcloud.grpc.model.UserServiceGrpc;
import com.google.protobuf.Any;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2024-01-24
 */
@GrpcService
public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    @Override
    public void queryUser(UserRequestVo request, StreamObserver<Result> responseObserver) {

        long id = request.getId();
        if (id != 1L) {
            responseObserver.onNext(null);
            responseObserver.onCompleted();
            return;
        }

        UserResponseVo.Builder userVoBuilder = UserResponseVo.newBuilder();
        userVoBuilder.setId(1L);
        userVoBuilder.setName("Zhang San");
        userVoBuilder.setSex("M");

        Result.Builder resultBuilder = Result.newBuilder();
        resultBuilder.setCode("SUCCEED");
        resultBuilder.setMessage("Succeed");
        resultBuilder.setSuccess(true);
        resultBuilder.setData(Any.pack(userVoBuilder.build()));

        responseObserver.onNext(resultBuilder.build());
        responseObserver.onCompleted();
    }
}
