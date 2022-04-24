package com.fengwenyi.demospringcloudfeign.goodsservice.controller;

import com.fengwenyi.api.result.PageRequestVo;
import com.fengwenyi.api.result.PageResponseVo;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringcloudfeign.goodsapi.IDemoApi;

import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-24
 */
public class DemoController implements IDemoApi {
    @Override
    public ResponseTemplate<PageResponseVo<List<?>>> queryPage(PageRequestVo requestVo) {
        return null;
    }

    public void test() {



    }
}
