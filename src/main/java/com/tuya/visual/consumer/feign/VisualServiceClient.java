package com.tuya.visual.consumer.feign;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * description
 *
 * @author 草薙
 * @since 2025/01/07
 */
@FeignClient(name = "visual-start", url = "http://localhost:8081")
public interface VisualServiceClient {

    @PostMapping("/v1.0/openapi/visual/d/user/login")
    String getStorageInfo(@RequestBody JSONObject jsonpObject);

}
