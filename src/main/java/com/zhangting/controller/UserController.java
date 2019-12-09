package com.zhangting.controller;

import com.zhangting.model.UserDO;
import com.zhangting.util.ResponseMsg;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 张挺（zhangting@binfo-tech.com）
 * @Description
 * @Date 2019/12/7 19:19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 获取登陆成功之后当前的用户信息
     * @return
     */
    @RequestMapping("/getCurrentUser")
    public ResponseMsg getCurrentUser() {
        try {
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return ResponseMsg.success(userDetails);
        } catch (Exception e) {
            return ResponseMsg.fail(-1, "获取用户信息失败;原因：" + e.toString());
        }
    }
}
