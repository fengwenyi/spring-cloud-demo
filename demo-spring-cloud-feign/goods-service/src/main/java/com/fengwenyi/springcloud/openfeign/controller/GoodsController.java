package com.fengwenyi.springcloud.openfeign.controller;

import com.fengwenyi.api.result.ListTemplate;
import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.springcloud.openfeign.constant.Constants;
import com.fengwenyi.springcloud.openfeign.goods.model.GoodsModel;
import com.fengwenyi.springcloud.openfeign.util.LocalCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-16
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @GetMapping("/list")
    public ResultTemplate<ListTemplate<GoodsModel>> list() {
        List<Object> objectList = LocalCache.get(Constants.KEY_GOODS);
        List<GoodsModel> goodsModelList = objectList.stream().map(o -> (GoodsModel) o).collect(Collectors.toList());
        ListTemplate<GoodsModel> listTemplate = new ListTemplate<>();
        listTemplate.setContent(goodsModelList);
        return ResultTemplate.success(listTemplate);
    }

}
