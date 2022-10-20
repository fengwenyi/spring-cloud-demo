package com.fengwenyi.rpc.sample.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.rpc.model.GoodsModel;
import com.fengwenyi.rpc.sample.rpc.GoodsRpcClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
@RestController
@RequestMapping("/rpc")
public class RpcController {

    private final GoodsRpcClient goodsRpcClient;

    public RpcController(GoodsRpcClient goodsRpcClient) {
        this.goodsRpcClient = goodsRpcClient;
    }

    @RequestMapping("/goods-list")
    public ResultTemplate<List<GoodsModel>> getGoodsList() {
        return goodsRpcClient.getList();
    }

    @RequestMapping("/goods-get")
    public ResultTemplate<GoodsModel> get(Integer id) {
        return goodsRpcClient.get(id);
    }

    @RequestMapping("/goods-search")
    public ResultTemplate<GoodsModel> search(String name, BigDecimal price) {
        return goodsRpcClient.search(name, price);
    }

    @RequestMapping("/goods-add")
    public ResultTemplate<List<GoodsModel>> add() {
        return goodsRpcClient.add(
                new GoodsModel()
                        .setId(5)
                        .setName("小米 K40")
                        .setNum(100)
                        .setPrice(new BigDecimal(2000))
        );
    }

}
