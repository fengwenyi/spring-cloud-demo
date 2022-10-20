package com.fengwenyi.rpc;

import lombok.Data;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-12
 */
@Data
public class MyRpcFactoryBean implements FactoryBean<Object> {

    private String url;

    private String contextPath;

    private String name;

    private Class<?> type;

    private BeanFactory beanFactory;

    private MyClient myClient;

    @Override
    public Object getObject() {

        Map<Method, RpcBean> map = new HashMap<>();

        Method[] methods = type.getMethods();

        myClient = beanFactory.getBean(MyClient.class);

        for (Method method : methods) {
            Annotation[] annotations = method.getAnnotations();
            String httpMethod = "";
            String path = "";
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == PostMapping.class) {
                    httpMethod = "POST";
                    path = ((PostMapping) annotation).value()[0];
                    break;
                } else if (annotation.annotationType() == GetMapping.class) {
                    httpMethod = "GET";
                    path = ((GetMapping) annotation).value()[0];
                    break;
                } else if (annotation.annotationType() == RequestMapping.class) {
                    RequestMapping requestMapping = ((RequestMapping) annotation);
                    httpMethod = requestMapping.method()[0].name();
                    path = requestMapping.value()[0];
                    break;
                }
            }
            RpcBean rpcBean = new RpcBean()
                    .setUrl(url + contextPath)
                    .setPath(path)
                    .setHttpMethod(httpMethod)
                    .setMyClient(myClient)
                    ;
            map.put(method, rpcBean);
        }

        ClassLoader loader = type.getClassLoader();

        return Proxy.newProxyInstance(loader, new Class<?>[] {type}, new MyRpcInvocationHandler(map));
    }

    @Override
    public Class<?> getObjectType() {
        return type;
    }

}
