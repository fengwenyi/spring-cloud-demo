package com.fengwenyi.springcloud.openfeign.data;

import javax.annotation.PostConstruct;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-16
 */
public abstract class BaseData {

    protected void init() {
        System.out.println("base data init");
    }

    @PostConstruct
    private void data() {
        init();
    }

}
