package com.fengwenyi.rpc;

import okhttp3.*;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-17
 */
public class HttpUtils {

    public static String post(String url, String param) {
        OkHttpClient client = getClient();

        RequestBody requestBody = RequestBody
                .create(param, MediaType.parse("application/json"));

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        return execute(client, request);
    }

    public static String get(String url, Map<String, String> map) {

        if (!CollectionUtils.isEmpty(map)) {
            StringBuilder urlBuilder = new StringBuilder(url + "?");
            for (Map.Entry<String, String> entry : map.entrySet()) {
                urlBuilder.append(String.format("%s=%s&", entry.getKey(), entry.getValue()));
            }
            url = urlBuilder.toString();
            url = url.substring(0, url.length() - 1);
        }

        return get(url);
    }

    public static String get(String url, String param) {
        if (StringUtils.hasText(param)) {
            url = url + "?" + param;
        }

        return get(url);
    }

    public static String get(String url) {
        OkHttpClient client = getClient();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        return execute(client, request);
    }

    private static OkHttpClient getClient() {
        return new OkHttpClient();
    }

    private static String execute(OkHttpClient client, Request request) {
        Call call = client.newCall(request);
        Response response;
        try {
            response = call.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            return Objects.requireNonNull(response.body()).string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
