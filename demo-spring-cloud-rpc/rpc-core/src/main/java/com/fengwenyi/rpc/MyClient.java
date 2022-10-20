package com.fengwenyi.rpc;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
public interface MyClient {

    String post(String url, String param);

    String get(String url, String param);

}
