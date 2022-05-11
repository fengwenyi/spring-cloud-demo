package com.fengwenyi.demospringcloudfeign.goodsclient.feign;

import com.fengwenyi.api.result.PageRequestVo;
import com.fengwenyi.api.result.PageResponseVo;
import com.fengwenyi.api.result.ResponseTemplate;
import com.fengwenyi.demospringcloudfeign.goodsclient.decoder.FeignDecoder;
import com.fengwenyi.demospringcloudfeign.goodsclient.vo.request.Params;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-24
 */
@FeignClient(
        value = "demo"
//        , configuration = FeignDecoder.class
)
public interface IDemoTemplate {

    @GetMapping("/demo")
    String demo(@SpringQueryMap Params params);

}
