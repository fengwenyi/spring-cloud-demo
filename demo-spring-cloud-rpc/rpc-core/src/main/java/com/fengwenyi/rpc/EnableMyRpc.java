package com.fengwenyi.rpc;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-13
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({MyRpcRegister.class, MyRpcAutoConfig.class})
public @interface EnableMyRpc {
}
