package com.zhangting.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 * @Date 2019/12/7 17:57
 */
@Controller
public class SystemController {
    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    /**
     * 密码加盐
     * @param args
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("1");
        System.out.println(password);
    }
}
