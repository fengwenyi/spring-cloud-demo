package com.fengwenyi.rpc.api.controller;

import com.fengwenyi.api.result.ResultTemplate;
import com.fengwenyi.rpc.model.GoodsModel;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    private static final List<GoodsModel> list = new ArrayList<>();

    static {
        list.add(new GoodsModel().setId(1).setName("iPhone 14").setPrice(new BigDecimal(8000)).setNum(100));
        list.add(new GoodsModel().setId(2).setName("iPhone 14 plus").setPrice(new BigDecimal(9000)).setNum(200));
        list.add(new GoodsModel().setId(3).setName("iPhone 14 pro").setPrice(new BigDecimal(7000)).setNum(300));
        list.add(new GoodsModel().setId(4).setName("iPhone 14 pro max").setPrice(new BigDecimal(5000)).setNum(1000));
    }

    @GetMapping("/list")
    public ResultTemplate<List<GoodsModel>> getList() {
        return ResultTemplate.success(list);
    }

    @GetMapping("/get")
    public ResultTemplate<GoodsModel> get(Integer id) {
        for (GoodsModel model : list) {
            if (Objects.equals(model.getId(), id)) {
                return ResultTemplate.success(model);
            }
        }
        return ResultTemplate.success();
    }

    @GetMapping("/search")
    public ResultTemplate<GoodsModel> search(String name, BigDecimal price) {
        for (GoodsModel model : list) {
            if (StringUtils.hasText(name) && model.getName().contains(name)) {
                return ResultTemplate.success(model);
            }
            if (Objects.nonNull(price) && model.getPrice().compareTo(price) == 0) {
                return ResultTemplate.success(model);
            }
        }
        return ResultTemplate.success();
    }

    @PostMapping("/add")
    public ResultTemplate<List<GoodsModel>> add(@RequestBody GoodsModel model) {
        list.add(model);
        return ResultTemplate.success();
    }

}
