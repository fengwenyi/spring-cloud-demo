package com.fengwenyi.rpc.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-10-20
 */
@Data
@Accessors(chain = true)
public class GoodsModel {

    private Integer id;
    private String name;
    private Integer num;
    private BigDecimal price;

}
