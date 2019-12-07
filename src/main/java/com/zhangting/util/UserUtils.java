package com.zhangting.util;

import com.zhangting.model.UserDO;
import org.springframework.security.core.context.SecurityContextHolder;


public class UserUtils {
    public static UserDO getCurrentUser() {
        return (UserDO) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
