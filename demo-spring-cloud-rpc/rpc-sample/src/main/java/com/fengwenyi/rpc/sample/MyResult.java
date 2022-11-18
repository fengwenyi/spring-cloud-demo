package com.fengwenyi.rpc.sample;

import com.fengwenyi.api.result.ResultTemplate;

import java.time.LocalDateTime;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-18
 */
public class MyResult<T> extends ResultTemplate<T> {

    public void setDate(String date) {
        super.setDate(LocalDateTime.parse(date));
    }
}
