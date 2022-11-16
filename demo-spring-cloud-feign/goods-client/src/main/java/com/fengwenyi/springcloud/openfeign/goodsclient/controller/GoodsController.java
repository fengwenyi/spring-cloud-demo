package com.fengwenyi.springcloud.openfeign.goodsclient.controller;

import com.fengwenyi.api.result.ListTemplate;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springcloud.openfeign.goodsclient.feign.IGoodsFeignClient;
import com.fengwenyi.springcloud.openfeign.goods.model.GoodsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-16
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private final IGoodsFeignClient goodsFeignClient;

    public GoodsController(IGoodsFeignClient goodsFeignClient) {
        this.goodsFeignClient = goodsFeignClient;
    }

    @GetMapping("/list")
    public ResultTemplate<ListTemplate<GoodsModel>> list() {
        return goodsFeignClient.list();
    }

}
