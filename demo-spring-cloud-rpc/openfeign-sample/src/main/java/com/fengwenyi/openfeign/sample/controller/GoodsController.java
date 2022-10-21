package com.fengwenyi.openfeign.sample.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.openfeign.sample.feign.GoodsFeignClient;
import com.fengwenyi.rpc.model.GoodsModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-21
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private final GoodsFeignClient goodsFeignClient;

    public GoodsController(GoodsFeignClient goodsFeignClient) {
        this.goodsFeignClient = goodsFeignClient;
    }

    @GetMapping("/list")
    public ResultTemplate<List<GoodsModel>> getList() {
        return goodsFeignClient.getList();
    }

}
