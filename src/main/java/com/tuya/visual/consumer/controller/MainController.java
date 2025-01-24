package com.tuya.visual.consumer.controller;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author 草薙
 * @since 2025/01/07
 */
@Slf4j
@RestController
public class MainController {

    @Value("${visual.server}")
    private String visualServer;

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/visual/token/get")
    public String getVisualAccessToken() {
        JSONObject params = new JSONObject();
        params.put("userName", "test_visual_user");
        params.put("password", "test_password");

        JSONObject device = new JSONObject();
        device.put("productKey", "wkNCAsnnlsYSnI6n");
        device.put("deviceName", "2ac4d7cffa");
        List<JSONObject> deviceList = new ArrayList<>();
        deviceList.add(device);

        params.put("deviceList", deviceList);
        log.info("params = {}", JSON.toJSONString(params));

        // 设置请求头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        // 创建请求体
        String jsonBody = params.toJSONString();
        // 包装请求体和请求头
        HttpEntity<String> requestEntity = new HttpEntity<>(jsonBody, headers);
        // 发送 POST 请求, 请求地址改成对应的域名地址
        String url = visualServer + "/v1.0/openapi/visual/d/user/login";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        // 处理响应
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Response: " + response.getBody());
        } else {
            System.out.println("Request failed with status code: " + response.getStatusCode());
        }
        String deviceVisualTokenListStr = response.getBody();

        return deviceVisualTokenListStr;
    }

}
