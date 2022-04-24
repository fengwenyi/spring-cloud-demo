package com.fengwenyi.demospringcloudfeign.goodsapi;

import com.fengwenyi.api.result.PageRequestVo;
import com.fengwenyi.api.result.PageResponseVo;
import com.fengwenyi.api.result.ResponseTemplate;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author <a href="https://www.fengwenyi.com">Erwin Feng</a>
 * @since 2022-04-24
 */
public interface IDemoApi {

    @GetMapping("/page")
    ResponseTemplate<PageResponseVo<List<?>>> queryPage(@SpringQueryMap PageRequestVo requestVo);

}
