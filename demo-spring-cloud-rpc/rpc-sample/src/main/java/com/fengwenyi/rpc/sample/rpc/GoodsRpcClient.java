package com.fengwenyi.rpc.sample.rpc;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.rpc.MyRpc;
import com.fengwenyi.rpc.model.GoodsModel;
import com.fengwenyi.rpc.sample.MyResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
@MyRpc(
        url = "http://localhost:9101",
        path = "/rpc-api"
)
public interface GoodsRpcClient {

    @GetMapping("/goods/list")
    MyResult<List<GoodsModel>> getList();

    @GetMapping("/goods/get")
    ResultTemplate<GoodsModel> get(Integer id);

    @GetMapping("/goods/search")
    ResultTemplate<GoodsModel> search(String name, BigDecimal price);

    @PostMapping("/goods/add")
    ResultTemplate<List<GoodsModel>> add(GoodsModel model);
}
