package com.tuya.visual.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * description
 *
 * @author 草薙
 * @since 2025/01/07
 */
@SpringBootApplication(scanBasePackages = {"com.tuya.visual"})
@EnableFeignClients
public class StartUp {
    public static void main(String[] args) {
        SpringApplication.run(StartUp.class, args);
    }
}
