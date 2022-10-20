package com.fengwenyi.rpc;

import com.fengwenyi.javalib.convert.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-12
 */
@Slf4j
public class MyRpcInvocationHandler implements InvocationHandler {

    private final Map<Method, RpcBean> map;

    public MyRpcInvocationHandler(Map<Method, RpcBean> map) {
        this.map = map;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("proxy handler");

        return request(method, args);
    }

    public Object request(Method method, Object[] args) {
        String result = "";
        RpcBean rpcBean = map.get(method);
        Parameter[] parameters = method.getParameters();
        Class<?> returnType = method.getReturnType();
        String url = rpcBean.getUrl() + rpcBean.getPath();
        String httpMethod = rpcBean.getHttpMethod();
        String param = getParam(httpMethod, parameters, args);
        log.info("url: [{}], param: [{}]", url, param);
        MyClient myClient = rpcBean.getMyClient();
        if ("POST".equals(httpMethod)) {
            result = myClient.post(url, param);
        } else if ("GET".equals(httpMethod)) {
            result = myClient.get(url, param);
        }
        if (StringUtils.hasText(result)) {
            return JsonUtils.convertObject(result, returnType);
        }
        return "";
    }

    public String getParam(String httpMethod, Parameter[] parameters, Object[] args) {
        if ("POST".equals(httpMethod)) {
            return JsonUtils.convertString(args[0]);
        } else if ("GET".equals(httpMethod)) {
            if (Objects.isNull(parameters) || parameters.length == 0
                    || Objects.isNull(args) || args.length == 0) {
                return "";
            }
            String param = "";
            StringBuilder urlBuilder = new StringBuilder(param);
            for (int i = 0; i < parameters.length; i++) {
                if (Objects.nonNull(args[i])) {
                    urlBuilder.append(String.format("%s=%s&", parameters[i].getName(), args[i]));
                }
            }
            param = urlBuilder.toString();
            param = param.substring(0, param.length() - 1);
            return param;
        }
        return "";
    }
}
