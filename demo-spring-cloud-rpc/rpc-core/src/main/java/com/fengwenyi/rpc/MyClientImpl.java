package com.fengwenyi.rpc;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
public class MyClientImpl implements MyClient {
    @Override
    public String post(String url, String param) {
        return HttpUtils.post(url, param);
    }

    @Override
    public String get(String url, String param) {
        return HttpUtils.get(url, param);
    }
}
