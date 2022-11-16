package com.fengwenyi.springcloud.openfeign.goodsclient.feign;

import com.fengwenyi.api.result.ListTemplate;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springcloud.openfeign.goods.model.GoodsModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-24
 */
@FeignClient(
        value = "openfeign-goods-service",
        path = "/goods"
)
public interface IGoodsFeignClient {

    @GetMapping("/list")
    ResultTemplate<ListTemplate<GoodsModel>> list();

}
