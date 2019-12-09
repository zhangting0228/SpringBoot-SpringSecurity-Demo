package com.zhangting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 */
@SpringBootApplication
public class PlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlatformApplication.class, args);
        System.out.println("================= 启动成功 =================");
    }
}
