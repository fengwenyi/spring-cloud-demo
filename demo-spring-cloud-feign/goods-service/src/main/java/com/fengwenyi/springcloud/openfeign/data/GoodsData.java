package com.fengwenyi.springcloud.openfeign.data;

import com.fengwenyi.springcloud.openfeign.constant.Constants;
import com.fengwenyi.springcloud.openfeign.goods.model.GoodsModel;
import com.fengwenyi.springcloud.openfeign.util.LocalCache;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;

/**
 * @author <a href="https://fengwenyi.com">Erwin Feng</a>
 * @since 2022-11-16
 */
@Component
public class GoodsData extends BaseData {

    @Override
    public void init() {
        LocalCache.set(Constants.KEY_GOODS, "1",
                new GoodsModel().setId(1).setName("iPhone 14").setPrice(new BigDecimal(5000)));
        LocalCache.set(Constants.KEY_GOODS, "2",
                new GoodsModel().setId(2).setName("iPhone 14 Plus").setPrice(new BigDecimal(8000)));
        LocalCache.set(Constants.KEY_GOODS, "3",
                new GoodsModel().setId(3).setName("iPhone 14 Pro").setPrice(new BigDecimal(6000)));
        LocalCache.set(Constants.KEY_GOODS, "4",
                new GoodsModel().setId(4).setName("iPhone 14 Pro Max").setPrice(new BigDecimal(9000)));
    }

}
