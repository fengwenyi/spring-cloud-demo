package com.fengwenyi.rpc;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-14
 */
@Data
@Accessors(chain = true)
public class RpcBean {

    private String url;

    private String path;

    private String httpMethod;

    private MyClient myClient;

}
