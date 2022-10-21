package com.fengwenyi.openfeign.sample.feign;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.rpc.model.GoodsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-21
 */
@FeignClient(
        name = "rpc-api",
        url = "http://localhost:9091",
        path = "/rpc-api"
)
public interface GoodsFeignClient {

    @GetMapping("/goods/list")
    ResultTemplate<List<GoodsModel>> getList();
}
