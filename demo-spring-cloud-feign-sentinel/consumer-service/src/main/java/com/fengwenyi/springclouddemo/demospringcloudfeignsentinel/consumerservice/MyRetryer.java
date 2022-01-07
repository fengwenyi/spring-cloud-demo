package com.fengwenyi.springclouddemo.demospringcloudfeignsentinel.consumerservice;

import feign.RetryableException;
import feign.Retryer;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-01-07
 */
public class MyRetryer implements Retryer {
    @Override
    public void continueOrPropagate(RetryableException e) {
        throw e;
    }

    @Override
    public Retryer clone() {
        return new Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}
